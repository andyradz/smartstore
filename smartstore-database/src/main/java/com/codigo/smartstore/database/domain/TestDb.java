package com.codigo.smartstore.database.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.codigo.smartstore.database.domain.catalog.Category;
import com.codigo.smartstore.database.domain.catalog.CategoryAttribute;
import com.codigo.smartstore.database.domain.catalog.MediaFile;

public class TestDb {

	private static final Logger log = Logger.getLogger(TestDb.class);

	public static void main(final String[] args) {

		try {

			final EntityManagerFactory emf = Persistence.createEntityManagerFactory("smartstore-database");

			final EntityManager em = emf.createEntityManager();

			final EntityTransaction tx = em.getTransaction();

			tx.begin();

			final var q1 = em.createQuery("DELETE FROM MediaFile");
			final var q2 = em.createQuery("DELETE FROM CategoryAttribute");
			final var q3 = em.createQuery("DELETE FROM Category");

			q1.executeUpdate();
			q2.executeUpdate();
			q3.executeUpdate();

			final Category cat = new Category();
			cat.setName("Produkty spożywcze9");
			cat.setAlias("PS");

			final var ca = new CategoryAttribute();
			ca.setName("Kodowanie9");
			ca.setSearchable(false);
			ca.setValue("Masakra9");
			ca.setCategory(cat);
			cat.getAttributes()
					.add(ca);

			final var file = new MediaFile();
			file.setName("cv.ar9");
			file.setCategory(cat);
			cat.getFiles()
					.add(file);

			em.persist(cat);

			// cat = new Category();
			// cat.setName("Produkty elektryczne");
			// cat.setAlias("PE");
			// em.persist(cat);

			// final IZipCode zip = new ZipCode();
			// zip.setCity("Poznań");
			// zip.setDistrict("Karczenki");
			// zip.setLatitude(Double.MAX_VALUE);
			// zip.setLongitude(Double.MIN_VALUE);
			// zip.setProvince("Mława");
			// zip.setStreet("Aleje Waszyngtona");
			// zip.setTownShip("Północny");
			// zip.setZip("06061");

			// em.persist(zip);

			tx.commit();

			final var category = em.find(Category.class, cat.getId());
			log.info(category);

			// category = em.find(Category.class, 2L);
			// log.info(category);
			//
			// category = em.find(Category.class, 3L);
			// log.info(category);
			//
			// final IZipCode z1 = em.find(ZipCode.class, 1L);
			// log.info(z1);

			// em.remove(category);
			if (em.isOpen())
				em.close();

		} catch (final Exception e) {

			e.printStackTrace();
		} finally {

		}

	}
}
