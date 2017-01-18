package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ConsumeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Go Spring Go");
		RestTemplate rest = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new LoggingRequestInterceptor());
		rest.setInterceptors(interceptors);

//		RestTemplate rest = new RestTemplate();
//		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//		ResponseEntity<String> r1 = rest.getForEntity("https://qrng.anu.edu.au/API/jsonI.php?length=5&type=uint16", String.class);
//		ResponseEntity<Map> r2 = rest.getForEntity("http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol=AAPL", Map.class);
//		Quote quote = rest.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//		ResponseEntity<Map> r3 = rest.getForEntity("http://api.fixer.io/latest", Map.class);
//		Fixer fixer = rest.getForObject("http://api.fixer.io/latest", Fixer.class);
//		Movie movie = rest.getForObject("http://www.omdbapi.com/?s=ring&page=1", Movie.class);

		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("User-Agent", "curl/7.49.0");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//		ResponseEntity<Map> r4 = rest.exchange("http://pokeapi.co/api/v2/type/3/", HttpMethod.GET, entity, Map.class);
		ResponseEntity<Pokeapi> r4 = rest.exchange("http://pokeapi.co/api/v2/type/3/", HttpMethod.GET, entity, Pokeapi.class);
	}
}
