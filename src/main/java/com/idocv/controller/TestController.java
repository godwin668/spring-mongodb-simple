package com.idocv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("test")
@Controller
public class TestController {

	@RequestMapping("hello")
	@ResponseBody
	public Map<String, String> hello() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Godwin");
		return map;
	}


}