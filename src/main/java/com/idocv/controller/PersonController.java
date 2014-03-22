package com.idocv.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idocv.po.Person;
import com.idocv.service.PersonService;

@RequestMapping("person")
@Controller
public class PersonController {

	@Resource
	private PersonService personService;

	@RequestMapping("save")
	@ResponseBody
	public Person save() {
		Person p = new Person("Godwin", 32);
		personService.save(p);
		return p;
	}
	
	@RequestMapping("{id}/delete")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") String id) {
		personService.delete(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		return map;
	}

	@RequestMapping("{id}/update")
	@ResponseBody
	public Map<String, Object> update(@PathVariable("id") String id,
			@RequestParam String name) {
		personService.update(id, name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		return map;
	}

	@RequestMapping("list")
	@ResponseBody
	public List<Person> list() {
		List<Person> list = personService.findAll();
		return list;
	}
}