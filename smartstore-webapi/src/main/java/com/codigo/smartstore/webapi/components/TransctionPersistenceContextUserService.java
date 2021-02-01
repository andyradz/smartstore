package com.codigo.smartstore.webapi.components;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class TransctionPersistenceContextUserService {

	@PersistenceContext()
	private EntityManager entityManager;

	// @Inject
	// private GenericRepository<Category> repository;
	//
	// @Transactional
	// public Category insertWithTransaction(final Category category) {
	//
	// // this.entityManager.persist(category);
	// this.repository.insert(category);
	// this.repository.persist();
	// return category;
	// }
	//
	// public Category insertWithoutTransaction(final Category category) {
	//
	// this.entityManager.persist(category);
	// return category;
	// }
	//
	// public Category find(final long id) {
	//
	// return this.entityManager.find(Category.class, id);
	// }
}