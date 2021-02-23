package com.codigo.smartstore.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.codigo.smartstore.database.domain.catalog.Category;
import com.codigo.smartstore.database.domain.catalog.CategoryAttribute;
import com.codigo.smartstore.database.domain.catalog.MediaFile;

public class HibernateUtil {

	private static String PROPERTY_FILE_NAME;

	public static SessionFactory getSessionFactory() throws IOException {

		return getSessionFactory(null);
	}

	public static SessionFactory getSessionFactory(final String propertyFileName) throws IOException {

		PROPERTY_FILE_NAME = propertyFileName;
		final ServiceRegistry serviceRegistry = configureServiceRegistry();
		return makeSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactoryByProperties(final Properties properties) throws IOException {

		final ServiceRegistry serviceRegistry = configureServiceRegistry(properties);
		return makeSessionFactory(serviceRegistry);
	}

	private static SessionFactory makeSessionFactory(final ServiceRegistry serviceRegistry) {

		final MetadataSources metadataSources = new MetadataSources(serviceRegistry);

		metadataSources.addPackage("com.codigo.smartstore.database.domain");
		metadataSources.addAnnotatedClass(Category.class);
		metadataSources.addAnnotatedClass(CategoryAttribute.class);
		metadataSources.addAnnotatedClass(MediaFile.class);

		final Metadata metadata = metadataSources.getMetadataBuilder()
				.build();

		return metadata.getSessionFactoryBuilder()
				.build();
	}

	private static ServiceRegistry configureServiceRegistry() throws IOException {

		return configureServiceRegistry(getProperties());
	}

	private static ServiceRegistry configureServiceRegistry(final Properties properties) throws IOException {

		return new StandardServiceRegistryBuilder().applySettings(properties)
				.build();
	}

	public static Properties getProperties() throws IOException {

		final Properties properties = new Properties();
		final URL propertiesURL = Thread.currentThread()
				.getContextClassLoader()
				.getResource("hibernate.properties");

		try (FileInputStream inputStream = new FileInputStream(propertiesURL.getFile())) {

			properties.load(inputStream);
		}
		return properties;
	}
}
