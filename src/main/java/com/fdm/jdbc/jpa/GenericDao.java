package com.fdm.jdbc.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class GenericDao<T extends Persistable<T>> {

	private final EntityManagerFactory emf;
	private final Class<T> clazz;

	public GenericDao(EntityManagerFactory emf, Class<T> clazz) {
		this.emf = emf;
		this.clazz = clazz;
	}

	public void add(T type) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(type);
		cleanUp(manager, transaction);

	}

	public void remove(int id) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		T found = manager.find(clazz, id);
		transaction.begin();
		manager.remove(found);
		cleanUp(manager, transaction);
	}

	private void cleanUp(EntityManager manager, EntityTransaction transaction) {
		transaction.commit();
		manager.close();
	}

	public void update(T updateType) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		T databaseType = manager.find(clazz, updateType.getId());
		transaction.begin();
		databaseType.update(updateType);
		cleanUp(manager, transaction);
	}

}
