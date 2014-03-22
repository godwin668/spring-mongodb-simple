package com.idocv.service;

import java.util.List;

import com.idocv.po.Person;

public interface PersonService {

	void save(Person person);

	void delete(String id);

	void update(String id, String name);

	List<Person> findAll();

}