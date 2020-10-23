package com.codigo.smartstore.webapi.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.codigo.smartstore.core.SerializedIntrospection;
import com.codigo.smartstore.webapi.domain.Book;
import com.codigo.smartstore.webapi.domain.Employee;
import com.codigo.smartstore.webapi.repository.BookRepository;
import com.codigo.smartstore.webapi.repository.EmployeeRepository;
import com.codigo.smartstore.webapi.services.CustomerIdGenerator;
import com.codigo.smartstore.webapi.services.ICustomerIdGenerator;

@Configuration
// @Slf4j
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initBooks(final BookRepository repository) {

		return args -> {

			log.info(String.format("Preloading %s ", repository.save(new Book())));

		};
	}

	@Bean
	CommandLineRunner initDatabase(final EmployeeRepository repository) {

		return args -> {

			var dataEntity = new Employee(
					"Zachariasz", "Zuzu", "1");
			dataEntity.setSize(SerializedIntrospection.sizeOf(dataEntity));
			repository.save(dataEntity);

			dataEntity = new Employee(
					"Bilbo Baggins", "burglar", "1");
			dataEntity.setSize(SerializedIntrospection.sizeOf(dataEntity));
			repository.save(dataEntity);

			dataEntity = new Employee(
					"Frodo Baggins", "thief", "2");
			dataEntity.setSize(SerializedIntrospection.sizeOf(dataEntity));
			repository.save(dataEntity);

			dataEntity = new Employee(
					"Andy", "admin", "3");
			dataEntity.setSize(SerializedIntrospection.sizeOf(dataEntity));
			repository.save(dataEntity);

			dataEntity = new Employee(
					"Kate", "secretary", "4");
			dataEntity.setSize(SerializedIntrospection.sizeOf(dataEntity));
			repository.save(dataEntity);

			dataEntity = new Employee(
					"Mike", "driver", "5");
			dataEntity.setSize(SerializedIntrospection.sizeOf(dataEntity));
			repository.save(dataEntity);
		};
	}

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {

		final CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeHeaders(true);
		return loggingFilter;
	}

	@Bean
	public ICustomerIdGenerator customIdGenerator() {

		return new CustomerIdGenerator();
	}
}
