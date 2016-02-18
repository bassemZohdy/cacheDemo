package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
	final private Map<Long, String> store;

	public CacheService() {
		this.store = new HashMap<>();
	}

	@Cacheable(cacheNames ="store",key="#id")
	public String get(Long id) {
		return store.get(id);
	}

	@CachePut(cacheNames = "store",key="#id")
	public String add(Long id, String v) {
		store.put(id, v);
		return v;
	}

	@CacheEvict(cacheNames = "store",key="#id")
	public void delete(Long id) {
		store.remove(id);
	}

}
