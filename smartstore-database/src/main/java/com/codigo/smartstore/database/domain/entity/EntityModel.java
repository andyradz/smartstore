package com.codigo.smartstore.database.domain.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.eclipse.persistence.annotations.Customizer;

/**
 * Model bazowy encji bazy danych Wszystkie nowe encje powinny dziedziczy z tego
 * modelu
 *
 * @author andrzej.radziszewski
 * @version 1.0.0.0
 * @since 2019
 * @category Entity
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
@Customizer(EntityColumnPositionCustomizer.class)
public abstract class EntityModel
	implements Serializable {

	private static final long serialVersionUID = -6333759041613153418L;

	// @Column(name = "Id")
	// @GeneratedValue(strategy = GenerationType.TABLE, generator =
	// "entity_generator")
	// @TableGenerator(name = "entity_generator", allocationSize = 50, initialValue
	// = 0)
	// protected Long id;
	//
	public abstract Long getId();
	//
	// return 1L;
	// }

	@Override
	public int hashCode() {

		return Objects.hash(1);
	}

	@Override
	public boolean equals(final Object obj) {

		if (obj == null)
			return false;

		if (this == obj)
			return true;

		if (!(obj instanceof EntityModel))
			return false;

		EntityModel.class.cast(obj);

		return Objects.equals(1, 1);
	}

	@Override
	public String toString() {

		return "EntityModel";
	}
}
