package com.codigo.smartstore.database.domain.location;

public interface IZipCode {

	/**
	 * Metoda pobiera wartość kodu pocztowego
	 * @return Wartość tekstowa
	 */
	String getZip();

	/**
	 * Metoda ustawia wartość kodu pocztowego
	 * @param zipcode Wartość kodu pocztowego
	 */
	void setZip(String zipcode);

	/**
	 * Metoda pobiera nazwę miasta
	 * @return Wartość tekstowa
	 */
	String getCity();

	/**
	 * Metoda ustawia wartośc nazwy miejscowości
	 * @param zipCity Nazwa miejscowości
	 */
	void setCity(String zipCity);

	double getLongitude();

	void setLongitude(double zipLongitude);

	double getLatitude();

	void setLatitude(double latitude);

	/**
	 * @return the street
	 */
	String getStreet();

	/**
	 * @param street the street to set
	 */
	void setStreet(String street);

	/**
	 * @return the province
	 */
	String getProvince();

	/**
	 * @param province the province to set
	 */
	void setProvince(String province);

	/**
	 * @return the townShip
	 */
	String getTownShip();

	/**
	 * @param townShip the townShip to set
	 */
	void setTownShip(String townShip);

	/**
	 * @return the district
	 */
	String getDistrict();

	/**
	 * @param district the district to set
	 */
	void setDistrict(String district);

}