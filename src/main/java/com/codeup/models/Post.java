package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Moses Franco on 6/20/17
 * Codeup
 * Pinnacles
 */

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Posts must have a title")
	@Size(min = 5, message = "Posts must have a title length of 5 - 120 characters")
	@Column(nullable = false, length = 120)
	private String title;

	@NotNull(message = "Your posts needs some text in the body")
	@Column(nullable = false, columnDefinition = "text")
	private String text;

	@ManyToOne
	@JsonManagedReference
	private User user;

	public Post(String title, String text, User user) {
		this.title = title;
		this.text = text;
		this.user = user;
	}

	public Post() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
