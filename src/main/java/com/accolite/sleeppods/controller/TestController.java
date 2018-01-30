package com.accolite.sleeppods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping(value="hello")
	public String sayHello() {
		return "hello world";
	}
}