package com.hillert.coherence.extend.demo.controller;

import com.oracle.coherence.spring.configuration.annotation.CoherenceMap;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.Coherence;
import com.tangosol.net.NamedCache;
import com.tangosol.net.Session;
import com.tangosol.util.processor.NumberIncrementor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Gunnar Hillert
 *
 */
@RestController
public class ProcessorController {

	@CoherenceMap("marketdata")
	NamedCache<String, Integer> cache;

	@CM("marketdata3")
	NamedCache<String, Integer> cache3;

	@GetMapping("/add/{symbol}")
	public void add(@PathVariable String symbol) {
		System.out.println("Got: " + symbol);
		this.cache.put(symbol, 0);
	}

	@GetMapping("/add2/{symbol}")
	public void add2(@PathVariable String symbol) {
		System.out.println("Got: " + symbol);
		CacheFactory.getCache("marketdata2").put(symbol, 0);
	}

	@GetMapping("/add3/{symbol}")
	public void add3(@PathVariable String symbol) {
		System.out.println("Got: " + symbol);
		this.cache3.put(symbol, 0);
	}

	@GetMapping("/process/{symbol}")
	public Integer process(@PathVariable String symbol) {
		System.out.println("Got: " + symbol);
		return cache.invoke(symbol, new NumberIncrementor<>(
				(String) null,
				1, false));
	}

	@GetMapping("/process2/{symbol}")
	public Integer process2(@PathVariable String symbol) {
		System.out.println("Got: " + symbol);


		final Session session = Coherence.findSession(Coherence.DEFAULT_NAME)
				.orElseThrow(() -> new IllegalStateException(String.format("No Session is configured with name '%s'.", "")));

		NamedCache<String, Integer> cache2 = CacheFactory.getCache("marketdata2");

		return cache2.invoke(symbol, new NumberIncrementor<>(
				(String) null,
				1, false));
	}

	@GetMapping("/process3/{symbol}")
	public Integer process3(@PathVariable String symbol) {
		System.out.println("Got: " + symbol);
		return cache3.invoke(symbol, new NumberIncrementor<>(
				(String) null,
				1, false));
	}
}
