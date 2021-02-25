package com.codigo.smartstore.database.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.database.HibernateUtil;
import com.codigo.smartstore.database.domain.catalog.Category;

class AggregateFunctionsIntegrationTest {

	private static Session session;
	private static Transaction transaction;

	@BeforeAll
	final static void setup() throws HibernateException, IOException {

		session = HibernateUtil.getSessionFactory()
				.openSession();
		transaction = session.beginTransaction();

		final Category jonas = new Category();
		jonas.setName("category1");
		jonas.setAlias("C1");

		session.save(jonas);
		session.getTransaction()
				.commit();
	}

	@AfterAll
	final static void teardown() {

		if (session != null) {

			transaction.rollback();
			session.close();
		}
	}

	@Test
	void whenAllEmployeesAreSelected_ThenSuccess() {

		final Query<Category> query = session.createQuery("from com.codigo.smartstore.database.domain.catalog.Category",
			Category.class);
		final List<Category> deptEmployees = query.list();
		final Category deptEmployee = deptEmployees.get(0);
		assertEquals("category1", deptEmployee.getName());
	}

	@Test
	void whenMaxAge_ThenReturnValue() {

		final Long val = (Long) session
				.createQuery("select count(1) as r from com.codigo.smartstore.database.domain.catalog.Category")
				.uniqueResult();

		// Criteria crit=session.createCriteria(BiMembres.class);
		// crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		// crit.add(Restrictions.eq("login", this.login));
		// ... OTHER Criterias if any..
		// //set the count projection
		// crit.setProjection(Projections.rowCount())
		// Long rowsCount = (Long)crit.uniqueResult();

		assertThat(1, equalTo(val));
	}

	// final int maxAge = (int) session.createQuery("SELECT MAX(age) from Student")
	// .getSingleResult();
	// assertThat(maxAge).isEqualTo(25);
	// }
	//
	// @Test
	// public void whenMinAge_ThenReturnValue() {
	//
	// final int minAge = (int) session.createQuery("SELECT MIN(age) from Student")
	// .getSingleResult();
	// assertThat(minAge).isEqualTo(20);
	// }
	//
	// @Test
	// public void whenAverageAge_ThenReturnValue() {
	//
	// final Double avgAge = (Double) session.createQuery("SELECT AVG(age) from
	// Student")
	// .getSingleResult();
	// assertThat(avgAge).isEqualTo(22.2);
	// }
	//
	// @Test
	// public void whenCountAll_ThenReturnValue() {
	//
	// final Long totalStudents = (Long) session.createQuery("SELECT COUNT(*) from
	// Student")
	// .getSingleResult();
	// assertThat(totalStudents).isEqualTo(5);
	// }
	//
	// @Test
	// public void whenSumOfAllAges_ThenReturnValue() {
	//
	// final Long sumOfAllAges = (Long) session.createQuery("SELECT SUM(age) from
	// Student")
	// .getSingleResult();
	// assertThat(sumOfAllAges).isEqualTo(111);
	// }
}
