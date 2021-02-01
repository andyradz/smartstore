package com.codigo.smartstore.database.domain.location;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.Index;

import com.codigo.smartstore.database.domain.entity.EntityModel;

@Entity
@Table(name = "ZipCode", uniqueConstraints = @UniqueConstraint(columnNames = { "Zip", "City" }))
public class ZipCode
		extends
		EntityModel
	implements Serializable, IZipCode {

	private static final long serialVersionUID = 6413677411110953856L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "zipcode_generator")
	// @SequenceGenerator(name = "zipcode_generator", sequenceName = "zipcode_seq",
	// allocationSize = 50)
	@TableGenerator(name = "zipcode_generator", initialValue = 0)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "Zip", insertable = true, updatable = true, nullable = false)
	@Index(name = "ZIPCODE_INDEX")
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Size(min = 5, max = 5)
	private String zip;

	@Column(name = "City", nullable = false)
	@Index(name = "ZIPCODE_CITY_INDEX", columnNames = { "City" })
	private String city;

	@Column(name = "Longitude")
	@Index(name = "ZIPCODE_LONGITUDE_INDEX", columnNames = { "Longitude" })
	private double longitude;

	@Column(name = "Latitude")
	@Index(name = "ZIPCODE_LATITUDE_INDEX", columnNames = { "Latitude" })
	private double latitude;

	@Column(name = "Street")
	@Index(name = "ZIPCODE_STREET_INDEX", columnNames = { "Street" })
	private String street;

	// województwo
	@Column(name = "Province", length = 50, nullable = true)
	private String province;

	@Column(name = "TowwnShip")
	private String townShip;

	// gmina
	@Column(name = "District", length = 50, nullable = true)
	private String district;

	@Override
	public String getZip() {

		return this.zip;
	}

	@Override
	public void setZip(final String zipcode) {

		this.zip = zipcode;
	}

	@Override
	public String getCity() {

		return this.city;
	}

	@Override
	public void setCity(final String zipCity) {

		this.city = zipCity;
	}

	@Override
	public double getLongitude() {

		return this.longitude;
	}

	@Override
	public void setLongitude(final double zipLongitude) {

		this.longitude = zipLongitude;
	}

	@Override
	public double getLatitude() {

		return this.latitude;
	}

	@Override
	public void setLatitude(final double latitude) {

		this.latitude = latitude;
	}

	/**
	 * @return the street
	 */
	@Override
	public String getStreet() {

		return this.street;
	}

	/**
	 * @param street the street to set
	 */
	@Override
	public void setStreet(final String street) {

		this.street = street;
	}

	/**
	 * @return the province
	 */
	@Override
	public String getProvince() {

		return this.province;
	}

	/**
	 * @param province the province to set
	 */
	@Override
	public void setProvince(final String province) {

		this.province = province;
	}

	/**
	 * @return the townShip
	 */
	@Override
	public String getTownShip() {

		return this.townShip;
	}

	/**
	 * @param townShip the townShip to set
	 */
	@Override
	public void setTownShip(final String townShip) {

		this.townShip = townShip;
	}

	/**
	 * @return the district
	 */
	@Override
	public String getDistrict() {

		return this.district;
	}

	/**
	 * @param district the district to set
	 */
	@Override
	public void setDistrict(final String district) {

		this.district = district;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = super.hashCode();

		result = (prime * result) + Objects.hash(this.city,
			this.district,
			this.id,
			this.latitude,
			this.longitude,
			this.province,
			this.street,
			this.townShip,
			this.zip);

		return result;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj)
			return true;

		if (!super.equals(obj))
			return false;

		if (!(obj instanceof ZipCode))
			return false;

		final ZipCode other = (ZipCode) obj;
		return Objects.equals(this.city, other.city) && Objects.equals(this.district, other.district)
				&& Objects.equals(this.id, other.id)
				&& (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(other.latitude))
				&& (Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(other.longitude))
				&& Objects.equals(this.province, other.province)
				&& Objects.equals(this.street, other.street)
				&& Objects.equals(this.townShip, other.townShip)
				&& Objects.equals(this.zip, other.zip);
	}

	@Override
	public String toString() {

		super.toString();

		return super.toString() + "ZipCode [id="
				+ this.id
				+ ", zip="
				+ this.zip
				+ ", city="
				+ this.city
				+ ", longitude="
				+ this.longitude
				+ ", latitude="
				+ this.latitude
				+ ", street="
				+ this.street
				+ ", province="
				+ this.province
				+ ", townShip="
				+ this.townShip
				+ ", district="
				+ this.district
				+ "]";
	}

	@Override
	public Long getId() {

		// TODO Auto-generated method stub
		return this.id;
	}
}