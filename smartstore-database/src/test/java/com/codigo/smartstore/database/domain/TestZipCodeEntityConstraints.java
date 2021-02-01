package com.codigo.smartstore.database.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codigo.smartstore.database.domain.location.ZipCode;
import com.codigo.smartstore.database.repository.GenericRepository;

@DisplayName("Walidaje pól encji ZipCode")
class TestZipCodeEntityConstraints {

	@Test
	@DisplayName("Walidacja wartości kod pocztowy gdy nie ma 5 wymaganych znaków")
	void testZipCode_ZipCode_Length_isNot5() throws IOException {

		try (GenericRepository<ZipCode> dbStore = new GenericRepository<>(
				ZipCode.class, "smartstore-database")) {

			final ZipCode zipCode = new ZipCode();

			zipCode.setCity("2323");
			zipCode.setDistrict("1212");
			zipCode.setLatitude(12);
			zipCode.setTownShip("Bydgoszcz");
			zipCode.setZip("223233");

			final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			final var validator = factory.getValidator();
			final Set<ConstraintViolation<ZipCode>> constraintViolations = validator.validate(zipCode);

			assertThat(1, equalTo(constraintViolations.size()));
			assertThat("wielkość musi należeć do zakresu od 5 do 5",
				equalTo(constraintViolations.iterator()
						.next()
						.getMessage()));
		}
	}

	@Test
	@DisplayName("Walidacja wartości kod pocztowy gdy nie ma wyłącznie znaków alfanumerycznych")
	void testZipCode_ZipCode_Letters_isNotAlfanumeric() throws IOException {

		try (GenericRepository<ZipCode> dbStore = new GenericRepository<>(
				ZipCode.class, "smartstore-database")) {

			final ZipCode zipCode = new ZipCode();

			zipCode.setZip("1234!");

			final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			final var validator = factory.getValidator();
			final Set<ConstraintViolation<ZipCode>> constraintViolations = validator.validate(zipCode);

			assertThat(1, equalTo(constraintViolations.size()));
			assertThat("musi pasować do wyrażenia ^[A-Za-z0-9]+$",
				equalTo(constraintViolations.iterator()
						.next()
						.getMessage()));
		}
	}

	@Test
	@DisplayName("Walidacja wartości kod pocztowy gdy ma 5 wymaganych znaków")
	void testZipCode_ZipCode_Length_is5() throws IOException {

		try (GenericRepository<ZipCode> dbStore = new GenericRepository<>(
				ZipCode.class, "smartstore-database")) {

			final ZipCode zipCode = new ZipCode();

			zipCode.setCity("2323");
			zipCode.setDistrict("1212");
			zipCode.setLatitude(12);
			zipCode.setTownShip("Bydgoszcz");
			zipCode.setZip("03126");

			final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			final var validator = factory.getValidator();
			final Set<ConstraintViolation<ZipCode>> constraintViolations = validator.validate(zipCode);

			assertThat(0, equalTo(constraintViolations.size()));
		}
	}

	@Test
	@DisplayName("Walidacja wartości kod pocztowy gdy ma wyłącznie znaki alfanumeryczne")
	void testZipCode_ZipCode_Letters_isAlfanumeric() throws IOException {

		try (GenericRepository<ZipCode> dbStore = new GenericRepository<>(
				ZipCode.class, "smartstore-database")) {

			final ZipCode zipCode = new ZipCode();

			zipCode.setZip("00000");
			zipCode.setCity("2323");
			zipCode.setDistrict("1212");
			zipCode.setLatitude(12);
			zipCode.setTownShip("Bydgoszcz");

			final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			final var validator = factory.getValidator();
			final Set<ConstraintViolation<ZipCode>> constraintViolations = validator.validate(zipCode);

			assertThat(0, equalTo(constraintViolations.size()));

		}
	}
}
