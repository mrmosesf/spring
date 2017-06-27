package com.codeup.repositories;

import com.codeup.models.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mosesfranco on 6/26/17
 * Codeup
 * Pinnacles
 */
public interface Roles extends CrudRepository<UserRole, Long> {
	@Query("select ur.role from UserRole ur, User u where u.username=?1 and ur.userId = u.id")
	public List<String> ofUserWith(String username);
}
