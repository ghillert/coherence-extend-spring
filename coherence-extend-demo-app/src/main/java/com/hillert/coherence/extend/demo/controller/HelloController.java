package com.hillert.coherence.extend.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.coherence.spring.configuration.annotation.CoherenceMap;

/**
 * @author Gunnar Hillert
 *
 */
@RestController
@RequestMapping(path="/hello")
public class HelloController {

	@CoherenceMap
	private Map<String, String> coherenceSpringMap;

	@GetMapping
	public String helloWorld() {
		return coherenceSpringMap.get("hello");
	}

}
