package com.codigo.smartstore.webapi.configuration;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class PersistenceJPAConfig {

	@Inject
	private Environment env;

	// @Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		em.setDataSource(this.dataSource());
		em.setPackagesToScan("com.codigo.smartstore.webapi.domain", "com.codigo.smartstore.webapi.repository");

		final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(this.additionalProperties());

		return em;
	}

	@Bean
	@ConfigurationProperties("spring.datasource.dev")
	public DataSource dataSource() {

		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl(
			"jdbc:sqlserver://;serverName=HWD19Y2\\MSSQL;port=64182;databaseName=smartstore;authenticationScheme=JavaKerberos");
		// integratedSecurity=true;domain=KDPW
		// dataSource.setUsername("");
		// dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(this.entityManagerFactory()
				.getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {

		return new PersistenceExceptionTranslationPostProcessor();
	}

	// @Bean(name = "getRepository")
	// public <T extends EntityModel> GenericRepository<T> getRepository(final
	// EntityManager em, final Class<T> domainType)
	// throws Exception {
	//
	// // public static EntityManagerFactory createEntityManagerFactory(String
	// // persistenceUnitName, Map properties) {
	// return new GenericRepository<>(em, domainType, "");
	// }

	Properties additionalProperties() {

		// spróbować to pobrać z projektu smartstore-databse
		final Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");

		return properties;
	}

}