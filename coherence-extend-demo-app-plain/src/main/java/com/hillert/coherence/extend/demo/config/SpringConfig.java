package com.hillert.coherence.extend.demo.config;

import com.tangosol.net.Coherence;
import com.tangosol.net.CoherenceConfiguration;
import com.tangosol.net.SessionConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Configuration
public class SpringConfig {

	@Bean
	Coherence coherenceInstance() {

		System.setProperty("coherence.tcmp.enabled", "false");
		final SessionConfiguration.Builder sessionConfigurationBuilder = SessionConfiguration.builder();
		sessionConfigurationBuilder.withConfigUri("remote-cache-config.xml");
		final SessionConfiguration sessionConfiguration = sessionConfigurationBuilder.build();

		final CoherenceConfiguration coherenceConfiguration = CoherenceConfiguration.builder()
				.withSession(sessionConfiguration)
				.build();

		final Coherence coherence = Coherence.client(coherenceConfiguration);

		try {
			coherence.start().get(5, TimeUnit.MINUTES);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			throw new RuntimeException(ex);
		}

		return coherence;
	}

}
