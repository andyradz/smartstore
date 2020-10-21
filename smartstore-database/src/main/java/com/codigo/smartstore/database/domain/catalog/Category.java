package com.codigo.smartstore.database.domain.catalog;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.eclipse.persistence.annotations.Customizer;

import com.codigo.smartstore.database.domain.entity.ColumnPosition;
import com.codigo.smartstore.database.domain.entity.EntityColumnPositionCustomizer;
import com.codigo.smartstore.database.domain.entity.EntityModel;

@Entity
@Table(name = "Category")
@Customizer(EntityColumnPositionCustomizer.class)
public class Category
		extends
		EntityModel {

	private static final long serialVersionUID = 5195542005041435577L;

	@AttributeOverride(name = "id", column = @Column(name = "Id"))
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
	@TableGenerator(name = "category_generator", initialValue = 0, allocationSize = 50)
	private Long id;

	@ColumnPosition(position = 1)
	@Column(name = "Name", nullable = false, unique = true, length = 20)
	private String name;

	@ColumnPosition(position = 2)
	@Column(name = "Alias", nullable = false, unique = true, length = 20)
	private String alias;

	@OneToMany(mappedBy = "category")
	Set<CategoryAttribute> attributes = new HashSet<>();

	public String getName() {

		return this.name;
	}

	public void setName(final String name) {

		this.name = name;
	}

}
