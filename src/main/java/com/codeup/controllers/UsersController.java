package com.codeup.controllers;

import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Created by mosesfranco on 6/26/17
 * Codeup
 * Pinnacles
 */
@Controller
public class UsersController {
	@Autowired
	UsersRepository usersDao;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@PostMapping("/users/register")
	public String saveUser(@Valid User user, Errors validation, Model model){
		if(!user.getPassword().equals(user.getPasswordConfirm())){
			model.addAttribute("errors", "Passwords do not match!");
			model.addAttribute("user", user);
			return "/register";
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		usersDao.save(user);

		return "redirect:/posts";
	}
}
