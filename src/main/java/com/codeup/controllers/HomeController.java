package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Moses Franco on 6/19/17
 * Codeup
 * Pinnacles
 */

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/portfolio")
	public String portfolio() {
		return "portfolio";
	}

	@GetMapping("/resume")
	public String resume() {
		return "resume";
	}

	@GetMapping("/roll-dice")
	public String guessANumber(Model model) {
		model.addAttribute("message", "Pick a number, roll the dice!");
		return "roll-dice";
	}

	@GetMapping("/roll-dice/{guess}")
	public String pickedNumber(@PathVariable int guess, Model model) {
		int randomNumber = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);

		model.addAttribute("number", guess);
		model.addAttribute("random", randomNumber);

		if (guess == randomNumber) {
			model.addAttribute("message", "You guessed correctly!");
		} else {
			model.addAttribute("message", "Guess again!");
		}
		return "roll-dice";
	}
}
