package com.hillert.coherence.extend.demo.controller;

import com.tangosol.net.Coherence;
import com.tangosol.net.NamedCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Gunnar Hillert
 *
 */
@RestController
@RequestMapping(path="/hello")
public class HelloController {

	@Autowired
	private Coherence coherence;

	@GetMapping
	public String helloWorld() {
		NamedCache<String, String> coherenceSpringMap = this.coherence.getSession().getCache("coherenceSpringMap");
		return coherenceSpringMap.get("hello");
	}

	@GetMapping("/all")
	public Map<String, String> allEntries() {
		Coherence coherenceInstance = Coherence.getInstance();
		NamedCache<String, String> coherenceSpringMap = coherenceInstance.getSession().getCache("coherenceSpringMap");
		return coherenceSpringMap;
	}

}
