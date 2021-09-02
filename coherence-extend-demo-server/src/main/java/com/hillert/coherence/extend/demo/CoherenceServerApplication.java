package com.hillert.coherence.extend.demo;

import com.oracle.coherence.spring.configuration.DefaultCoherenceConfigurer;
import com.oracle.coherence.spring.configuration.support.CoherenceInstanceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
public class CoherenceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoherenceServerApplication.class, args);
	}

}
