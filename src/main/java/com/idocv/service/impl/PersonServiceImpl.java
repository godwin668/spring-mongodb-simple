package com.idocv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.idocv.po.Person;
import com.idocv.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Resource
	private MongoOperations mongoOperations;

	@Override
	public void save(Person person) {
		mongoOperations.save(person);
		logger.info("save person success: " + person);
	}

	@Override
	public void delete(String id) {
		Person p = new Person(null, 0);
		p.setId(id);
		mongoOperations.remove(p);
		logger.info("delete person(" + id + ") success!");
	}

	@Override
	public void update(String id, String name) {
		mongoOperations.updateFirst(Query.query(Criteria.where("id").is(id)), Update.update("name", name), Person.class);
		logger.info("update person(" + id + ") success!");
	}

	@Override
	public List<Person> findAll() {
		return mongoOperations.findAll(Person.class);
	}

}