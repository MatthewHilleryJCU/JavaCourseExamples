package com.fdm.jdbc.jpa;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class GenericDaoTest {
	
	private final EntityManagerFactory emf = mock(EntityManagerFactory.class);
	private final EntityManager manager = mock(EntityManager.class);
	private final EntityTransaction transaction = mock(EntityTransaction.class);
	private final GenericDao<Pig> pigDao = new GenericDao<>(emf, Pig.class);
	private final Pig pig = mock(Pig.class);
	
	@Before
	public void setUp() {
		when(emf.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
	}
	
	@Test
	public void persists_pigs_to_database() {
		
		pigDao.add(pig);
		
		InOrder order =inOrder(transaction, manager);
		order.verify(transaction).begin();
		order.verify(manager).persist(pig);
		order.verify(transaction).commit();
		order.verify(manager).close();
	}
	
	@Test
	public void remove_pig_from_datebase() {
		when(manager.find(Pig.class, 5)).thenReturn(pig);
		
		pigDao.remove(5);
		
		InOrder order =inOrder(transaction, manager);
		
		
		verifyTransaction(order, () -> {order.verify(manager).remove(pig); });
		
		
		
	}
	
	@Test 
	public void update_pig_in_database_with_the_updated_pig() {
		Pig datebasePig = mock(Pig.class);
		Pig updatePig = mock(Pig.class);
		
		when(updatePig.getId()).thenReturn(5);
		when(manager.find(Pig.class, 5)).thenReturn(datebasePig);
		
		pigDao.update(updatePig);
		
		InOrder order = inOrder(transaction, manager, datebasePig);
		verifyTransaction(order, () -> { order.verify(datebasePig).update(updatePig); });
	}
		
	
	private void verifyTransaction(InOrder order, Runnable runner) {
		order.verify(transaction).begin();
		runner.run();
		order.verify(transaction).commit();
		order.verify(manager).close();
		
	}
	
	
}
