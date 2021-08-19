package com.hillert.coherence.extend.demo;

import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oracle.coherence.spring.configuration.annotation.CoherenceMap;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
public class CoherenceExtendDemoApplication implements ApplicationRunner {

	@CoherenceMap
	private Map<String, String> coherenceSpringMap;

	public static void main(String[] args) {
		SpringApplication.run(CoherenceExtendDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		coherenceSpringMap.put("hello", "world");
	}

}
