package com.example.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetController  {
	
	@RequestMapping(value = "", method = RequestMethod.GET) // same as(By default request method) @RequestMapping("/")
	public String sayHello() {
		return "Welcome to Bangladesh";
	}
	
	@RequestMapping("/form")
	public String userForm() {
		return " <form action=\"/greet/form_entry\" method=\"POST\" >\n"
				+ "  <label for=\"fname\">First name:</label><br>\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"fname\"><br>\n"
				+ "  <label for=\"lname\">Last name:</label><br>\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>\n"
				+ "  <input type=\"submit\" value=\"Submit\">\n"
				+ "</form> ";
	}
	
	@RequestMapping(value="/form_entry", method = RequestMethod.POST)
	public String printUserForm(@RequestParam String fname, @RequestParam String lname) {
		return "Hey " + fname + " " + lname;
	}
	
	@RequestMapping("/order/{id}")
	public String getOrder(@PathVariable String id) {
		return "<h1>Order id: "+ id +"</h1>";
	}
}
