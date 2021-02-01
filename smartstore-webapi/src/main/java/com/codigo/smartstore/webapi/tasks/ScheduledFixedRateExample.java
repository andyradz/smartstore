package com.codigo.smartstore.webapi.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class ScheduledFixedRateExample {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"HH:mm:ss");

	@Async("asyncExecutor")
	@Scheduled(fixedRate = 10000)
	public void scheduleFixedRateTaskAsync()
			throws InterruptedException, JsonMappingException, JsonProcessingException {

		// final String requestUrl =
		//
		// "http://tst-stream.kdpw.pl:27202/api/participationMethodList?CARef=4101GMET20082601";
		// final String requestUrl =
		// "http://tst-stream.kdpw.pl:27202/api/voteRegistrationCnf?CARef=4198XMET20100101";
		// final RestTemplate response = new RestTemplate();
		// final var resStr = response.getForObject(requestUrl, String.class);

		// final ObjectMapper mapper = new ObjectMapper();
		// final JsonNode root = mapper.readTree(resStr);
		// root.path("rates");

		// ObjectMapper mapper = new ObjectMapper();
		// Entries obj = mapper.readValue(rrateResponse.getBody(), Entries.class);
		// ResponseEntity<Entries> result = restTemplate.exchange(uri,
		// HttpMethod.GET,
		// entity, Entries.class);

		// final RestTemplate restTemplate = new RestTemplate();
		// final String fooResourceUrl = "https://api.exchangeratesapi.io/latest";
		// final ResponseEntity<String> response =
		// restTemplate.getForEntity(fooResourceUrl, String.class);

		// System.out.println(resStr);
		log.info("The time is now {}", this.dateFormat.format(new Date()));
		System.out.println("Fixed rate task async - " + (System.currentTimeMillis() / 5000));
	}

}
