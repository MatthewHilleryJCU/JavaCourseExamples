package com.fdm.jdbc.storedproc;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdm.jdbc.jpa.GenericDao;
import com.fdm.jdbc.jpa.Pig;


public class RunJPA {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDBconnect");
		GenericDao<Pig> pigDao = new GenericDao<>(emf, Pig.class);
		Pig pig = new Pig();
		
		pigDao.add(pig);
		emf.close();
	}	
}
