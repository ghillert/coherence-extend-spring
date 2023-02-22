package com.hillert.coherence.extend.demo;

import com.tangosol.net.Coherence;
import com.tangosol.net.NamedCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
public class CoherenceExtendDemoApplication implements ApplicationRunner {

	@Autowired
	private Coherence coherence;

	public static void main(String[] args) {
		SpringApplication.run(CoherenceExtendDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		NamedCache<String, String> coherenceSpringMap = this.coherence.getSession().getCache("coherenceSpringMap");
		coherenceSpringMap.put("hello", "world");
	}

}
