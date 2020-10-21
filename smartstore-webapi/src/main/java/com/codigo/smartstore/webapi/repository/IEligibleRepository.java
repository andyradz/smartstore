package com.codigo.smartstore.webapi.repository;

public interface IEligibleRepository
	extends IRepository {

	long countActivesEntities();

	long countApprovedEntities();

	long countNewEntities();

	// getLastActiveEntity
	// getNewestActiveEntity

	// getNexActiveEntity(Entity)
	// getPriorActiveEntity(Entity)

	// getNearestActiveEntity(Entity)
	// long getNearestAciveEntity(Date)

	// long countCanceledEntities();
}
