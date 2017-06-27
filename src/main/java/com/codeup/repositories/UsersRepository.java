package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Moses Franco on 6/22/17
 * Codeup
 * Pinnacles
 */
public interface UsersRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
