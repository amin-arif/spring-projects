package com.example.boot.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot.entity.Product;

@RestController
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("")
	public String index() {
		return "User home";
	}
	
	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User Id: " + userId;
	}
	
	@RequestMapping("/{userId}/invoice")
	public String displayUserInvoices(@PathVariable int userId, @RequestParam(value="date", required=false) Date dateOrNull) {
		return "Invoice for user: " + userId + " on " + dateOrNull;
	}
	
	@RequestMapping("/emplist")
	public List<String> getEmpList() {
		return Arrays.asList("Sobur", "Saddam", "Labib", "Laila");
	}
	
	@RequestMapping("/product_as_json")
	public List<Product> productAsJson() {
		return Arrays.asList(
					new Product(1, "Apple", 40),
					new Product(2, "Banana", 100.5),
					new Product(3, "Cherry", 200)
				);
	}
}









