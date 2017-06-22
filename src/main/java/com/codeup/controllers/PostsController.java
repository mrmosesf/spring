package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.svcs.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moses Franco on 6/19/17
 * Codeup
 * Pinnacles
 */

@Controller
public class PostsController {
	private final PostSvc postsDao;

	@Autowired
	public PostsController(PostSvc postsDao){
		this.postsDao = postsDao;
	}

	@GetMapping("/posts")
	public String indexPosts(Model model) {

//		Did this in two lines because okay
		List<Post> posts = postsDao.findAll();
		model.addAttribute("post", posts);
		return "posts/index";
	}

	@GetMapping("/posts/{id}")
	public String viewPost(@PathVariable long id, Model model) {
//		Did this in on-line because I learned since the last time adding an attribute to the model
		model.addAttribute("post", postsDao.findOne(id));
		return "posts/single";
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
