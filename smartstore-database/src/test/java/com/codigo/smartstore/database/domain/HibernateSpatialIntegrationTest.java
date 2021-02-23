package com.codigo.smartstore.database.domain;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.database.HibernateUtil;

public class HibernateSpatialIntegrationTest {

	private Session session;
	private Transaction transaction;

	@BeforeEach
	public void setUp() throws IOException {

		this.session = HibernateUtil.getSessionFactory("hibernate.properties")
				.openSession();
		this.transaction = this.session.beginTransaction();
		this.session.doWork(conn -> {

		});
	}

	@AfterEach
	public void tearDown() {

		this.transaction.rollback();
		this.session.close();
	}

	@Test
	public void shouldConvertWktToGeometry() {

		System.out.println("1212");
	}
}