package com.codigo.smartstore.webapi.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	@Async("asyncExecutor")
	public void reportCurrentTime() {

		// https://api.exchangeratesapi.io/latest HTTP/1.1

		log.info("The time is now {}", this.dateFormat.format(new Date()));
	}
}