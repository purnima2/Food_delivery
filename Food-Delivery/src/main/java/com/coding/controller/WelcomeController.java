package com.coding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.model.Customer;

@RestController
public class WelcomeController {

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcom user";
	}
}
