package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Moses Franco on 6/19/17
 * Codeup
 * Pinnacles
 */

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(){
		return "index";
	}

	@GetMapping("/portfolio")
	public String portfolio(){
		return "portfolio";
	}

	@GetMapping("/resume")
	public String resume(){
		return "resume";
	}
}
