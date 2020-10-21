package com.codigo.smartstore.database.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.Customizer;

import com.codigo.smartstore.database.domain.common.LogicalStates;
import com.codigo.smartstore.database.domain.entity.ColumnPosition;
import com.codigo.smartstore.database.domain.entity.EntityColumnPositionCustomizer;
import com.codigo.smartstore.database.domain.entity.ManagedEntityModel;

@Entity
@Table(name = "Parameter", uniqueConstraints = @UniqueConstraint(columnNames = { "ParameterKey", "SubtypeKey" }))
@Customizer(EntityColumnPositionCustomizer.class)
public class Parameter
		extends
		ManagedEntityModel {

	private static final long serialVersionUID = 6571250117545511181L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "parameter_generator")
	@TableGenerator(name = "parameter_generator", allocationSize = 50, initialValue = 0)
	private Long id;

	@ColumnPosition(position = 1)
	@Column(name = "ParameterKey", unique = false, length = 16, nullable = false, updatable = false)
	@NotEmpty
	@Size(min = 1, max = 16)
	private String parameterKey;

	@ColumnPosition(position = 2)
	@Column(name = "SubtypeKey", unique = false, length = 16)
	private String subtypeKey;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "SubtypeId")
	private Parameter subtype;

	@OneToMany(mappedBy = "subtype")
	Set<Parameter> parameters = new HashSet<>();

	@Enumerated(EnumType.STRING)
	@Column(name = "Factural") // czy merytoryczny
	LogicalStates factual = LogicalStates.NO;

	public String getParameterKey() {

		return this.parameterKey;
	}

	public void setParameterKey(final String parameterKey) {

		this.parameterKey = parameterKey;
	}

	public String getSubtypeKey() {

		return this.subtypeKey;
	}

	public void setSubtypeKey(final String subtypeKey) {

		this.subtypeKey = subtypeKey;
	}

	public Parameter getSubtype() {

		return this.subtype;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + Objects.hash(this.factual, this.id, this.parameterKey, this.parameters,
			this.subtype, this.subtypeKey);
		return result;
	}

	public void setSubtype(final Parameter subtype) {

		this.subtype = subtype;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj)
			return true;

		if (!super.equals(obj))
			return false;

		if (!(obj instanceof Parameter))
			return false;

		final Parameter other = (Parameter) obj;
		return (this.factual == other.factual) && Objects.equals(this.id, other.id)
				&& Objects.equals(this.parameterKey, other.parameterKey)
				&& Objects.equals(this.parameters, other.parameters)
				&& Objects.equals(this.subtype, other.subtype)
				&& Objects.equals(this.subtypeKey, other.subtypeKey);
	}

	@Override
	public String toString() {

		return "Parameter [id=" + this.id
				+ ", parameterKey="
				+ this.parameterKey
				+ ", subtypeKey="
				+ this.subtypeKey
				+ ", subtype="
				+ this.subtype
				+ ", parameters="
				+ this.parameters
				+ ", factual="
				+ this.factual
				+ "]";
	}

}
