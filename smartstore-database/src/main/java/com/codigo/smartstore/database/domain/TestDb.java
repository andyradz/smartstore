package com.codigo.smartstore.database.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.codigo.smartstore.database.domain.catalog.Category;
import com.codigo.smartstore.database.domain.location.IZipCode;
import com.codigo.smartstore.database.domain.location.ZipCode;

public class TestDb {

	public static void main(final String[] args) {

		try {

			final EntityManagerFactory emf = Persistence.createEntityManagerFactory("smartstore-database");

			final EntityManager em = emf.createEntityManager();

			final EntityTransaction tx = em.getTransaction();

			tx.begin();
			Category cat = new Category();
			cat.setName("wqew");
			cat.setAlias("koko");
			em.persist(cat);

			cat = new Category();
			cat.setName("wqewr");
			cat.setAlias("kok");
			em.persist(cat);

			final IZipCode zip = new ZipCode();
			zip.setCity("Poznań");
			zip.setDistrict("Karczenki");
			zip.setLatitude(1212121);
			zip.setLongitude(23);
			zip.setProvince("komorniki");
			zip.setStreet("Bydgoska");
			zip.setTownShip("Zachód");
			zip.setZip("03126");
			em.persist(zip);

			tx.commit();

			var category = em.find(Category.class, 1L);
			System.out.println(category);

			category = em.find(Category.class, 2L);
			System.out.println(category);

			category = em.find(Category.class, 3L);
			System.out.println(category);

			final IZipCode z1 = em.find(ZipCode.class, 1L);
			System.out.println(z1);

		} catch (final Exception e) {

			e.printStackTrace();
		}

	}
}
