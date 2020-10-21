package com.codigo.smartstore.database.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDb {

	public static void main(final String[] args) {

		try {

			final EntityManagerFactory emf = Persistence.createEntityManagerFactory("smartstore-database");

			final EntityManager em = emf.createEntityManager();

			final EntityTransaction tx = em.getTransaction();

			tx.begin();

			tx.commit();

		} catch (final Exception e) {

			e.printStackTrace();
		}

	}
}
