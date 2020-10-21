package com.codigo.smartstore.webapi.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public class ScheduledFixedRateExample {

	@Async("asyncExecutor")
	// @Scheduled(
	// fixedRate = 10000)
	public void scheduleFixedRateTaskAsync()
			throws InterruptedException, JsonMappingException, JsonProcessingException {

		// final String requestUrl =
		// "http://tst-stream.kdpw.pl:27202/api/participationMethodList?CARef=4101GMET20082601";
		final String requestUrl = "http://tst-stream.kdpw.pl:27202/api/voteRegistrationCnf?CARef=4198XMET20100101";
		final RestTemplate response = new RestTemplate();
		final var resStr = response.getForObject(requestUrl, String.class);

		// final ObjectMapper mapper = new ObjectMapper();
		// final JsonNode root = mapper.readTree(resStr);
		// root.path("rates");

		// ObjectMapper mapper = new ObjectMapper();
		// Entries obj = mapper.readValue(rrateResponse.getBody(), Entries.class);
		// ResponseEntity<Entries> result = restTemplate.exchange(uri, HttpMethod.GET,
		// entity, Entries.class);

		// final RestTemplate restTemplate = new RestTemplate();
		// final String fooResourceUrl = "https://api.exchangeratesapi.io/latest";
		// final ResponseEntity<String> response =
		// restTemplate.getForEntity(fooResourceUrl, String.class);

		System.out.println(resStr);
		System.out.println("Fixed rate task async - " + (System.currentTimeMillis() / 5000));
		Thread.sleep(5000);
	}

}

// @JsonIgnoreProperties(
// ignoreUnknown = true)
// class Entries {
//
// @JsonProperty("Entries")
// private List<Entry> Entries;

// getter and setter