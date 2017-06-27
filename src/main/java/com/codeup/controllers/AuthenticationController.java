package com.codeup.controllers;

import com.codeup.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by mosesfranco on 6/26/17
 * Codeup
 * Pinnacles
 */
@Controller
public class AuthenticationController {

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
}