package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
	
	Iterable<Customer> findByName(String name);

}
