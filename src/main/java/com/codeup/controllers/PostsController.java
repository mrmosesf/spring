package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Moses Franco on 6/19/17
 * Codeup
 * Pinnacles
 */

@Controller
public class PostsController {

	@GetMapping("/posts")
	@ResponseBody
	public String indexPosts() {
		return "posts index page";
	}

	@GetMapping("/posts/{id}")
	@ResponseBody
	public String viewPost(@PathVariable String id) {
		return String.format("view an individual post: %s", id);
	}

	@GetMapping("/posts/create")
	@ResponseBody
	public String createForm() {
		return "view the form for creating a post";
	}

	@PostMapping("/posts/create")
	public String saveForm(){
		return "create a new post";
	}
}
