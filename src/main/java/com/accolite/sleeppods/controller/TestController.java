package com.accolite.sleeppods.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	final static Logger logger = Logger.getLogger(TestController.class);

	@GetMapping(value="hello")
	public String sayHello() {
		logger.debug("hello logger");
		return "hello world";
	}
}
