package com.hillert.coherence.extend.demo;

import com.oracle.coherence.spring.configuration.DefaultCoherenceConfigurer;
import com.oracle.coherence.spring.configuration.annotation.CoherenceMap;
import com.oracle.coherence.spring.configuration.support.CoherenceInstanceType;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
public class CoherenceServerApplication implements ApplicationRunner {

	@CoherenceMap
	private Map<String, String> coherenceSpringMap;

	public static void main(String[] args) {
		SpringApplication.run(CoherenceServerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		coherenceSpringMap.put("server", "says hello");
	}
}
