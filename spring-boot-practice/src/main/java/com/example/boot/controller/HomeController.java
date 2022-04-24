package com.example.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.boot.entity.*;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		
		return "index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String handleForm(User user, RedirectAttributes attr) {
		
		// redirect to showFormData including user object
		attr.addFlashAttribute("user", user);
		return "redirect:/show-user";
	}
	
	@RequestMapping("show-user")
	public String showFormData(User user) {		
		return "show";
	}
	
}
