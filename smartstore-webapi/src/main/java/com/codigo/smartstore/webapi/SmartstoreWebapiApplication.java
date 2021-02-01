package com.codigo.smartstore.webapi;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
@EnableJpaRepositories
// @PropertySource("classpath:/com/acme/app.properties")
public class SmartstoreWebapiApplication {

	private static ConfigurableApplicationContext context;

	public static void main(final String[] args) {

		context = SpringApplication.run(SmartstoreWebapiApplication.class, args);
	}

	public static void restart() {

		final ApplicationArguments args = context.getBean(ApplicationArguments.class);

		final Thread thread = new Thread(
				(
				) -> {

					context.close();
					context = SpringApplication.run(SmartstoreWebapiApplication.class, args.getSourceArgs());
				});

		thread.setDaemon(false);
		thread.start();
	}
}