package com.idocv;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.idocv.po.Person;
import com.mongodb.MongoClient;

public class MongoApp {

	private static final Log log = LogFactory.getLog(MongoApp.class);

	public static void main(String[] args) throws Exception {

		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(
				new MongoClient("192.168.1.200", 27017), "spring-mongo"));

		Person p = new Person("Joe", 34);
		p.setId(new ObjectId().toString());

		// Insert is used to initially store the object into the database.
		mongoOps.insert(p);
		log.info("Insert: " + p);

		// Find
		p = mongoOps.findById(p.getId(), Person.class);
		log.info("Found: " + p);

		// Update
		mongoOps.updateFirst(query(where("name").is("Joe")), update("age", 35),
				Person.class);
		p = mongoOps.findOne(query(where("name").is("Joe")), Person.class);
		log.info("Updated: " + p);

		// Delete
		// mongoOps.remove(p);

		// Check that deletion worked
		List<Person> people = mongoOps.findAll(Person.class);
		log.info("Number of people = : " + people.size());

		// mongoOps.dropCollection(Person.class);
	}
}