package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Moses Franco on 6/20/17
 * Codeup
 * Pinnacles
 */

@Service("postSvc")
public class PostSvc {

	private PostsRepository postsDao;

	@Autowired
	public PostSvc(PostsRepository postsDao) {
		this.postsDao = postsDao;
	}

	public Iterable<Post> findAll() {
		return postsDao.findAll();
	}

	public Post save(Post post) {
		postsDao.save(post);
		return post;
	}

	public Post findOne(long id) {
		return postsDao.findOne(id);
	}

	public void deletePost(long id){
		postsDao.delete(id);
	}

}
