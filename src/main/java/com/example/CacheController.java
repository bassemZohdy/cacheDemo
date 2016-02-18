package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
	@Autowired
	CacheService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void add(@PathVariable Long id, @RequestBody String value) {
		service.add(id, value);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
