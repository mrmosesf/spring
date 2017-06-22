package com.codeup.svcs;

import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moses Franco on 6/20/17
 * Codeup
 * Pinnacles
 */

@Service("postSvc")
public class PostSvc {
	private List<Post> posts;


	public PostSvc() {
		createPosts();
	}

	public List<Post> findAll() {
		return posts;
	}

	public Post save(Post post) {
		post.setId(posts.size() + 1);
		posts.add(post);
		return post;
	}

	public Post findOne(long id) {
		return posts.get((int) (id - 1));
	}

	private void createPosts() {
		posts = new ArrayList<>();

		save(new Post("Going to Colorado", "Planning to go hiking, seeing some bands play, and meeting a friend"));
		save(new Post("Making a capstone project", "So far it has involved a lot of setup, and rethinking on my part"));
	}
}
