package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Moses Franco on 6/22/17
 * Codeup
 * Pinnacles
 */
public interface PostsRepository extends CrudRepository<Post, Long>{
}
