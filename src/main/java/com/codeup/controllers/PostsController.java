package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.UsersRepository;
import com.codeup.svcs.PostSvc;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
	private final UsersRepository usersDao;


	@Autowired
	public PostsController(PostSvc postsDao, UsersRepository usersDao) {
		this.postsDao = postsDao;
		this.usersDao = usersDao;
	}

	@GetMapping("/posts")
	public String indexPosts(Model model) {

//		Did this in two lines because okay
		Iterable<Post> posts = postsDao.findAll();
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
	public String createForm(Model model) {
		model.addAttribute("post", new Post());
		return "posts/create";
	}

	@PostMapping("/posts/create")
	public String saveForm(@RequestParam(name = "title") String title,
	                       @RequestParam(name = "text") String text,
	                       @Valid Post post,
	                       Errors validation,
	                       Model model) {

		if (validation.hasErrors()) {
			model.addAttribute("errors", validation);
			model.addAttribute("post", post);
			return "posts/create";
		}

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		post.setUser(user);
		postsDao.save(post);
		model.addAttribute("post", post);
		return "redirect:/posts/index";
	}

	@GetMapping("/posts/{id}/edit")
	public String editForm(@PathVariable long id, Model model) {
		model.addAttribute("post", postsDao.findOne(id));
		return "posts/edit";
	}

	@PostMapping("/posts/{id}/edit")
	public String editPost(@ModelAttribute Post post) {
		postsDao.save(post);
		return "redirect:/posts/" + post.getId();
	}

	@PostMapping("posts/delete")
	public String deletePost(@ModelAttribute Post post, Model model){
		postsDao.deletePost(post.getId());
		model.addAttribute("msg", "Success! Post delete");
		return "posts/index";
	}
}
