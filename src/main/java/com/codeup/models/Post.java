package com.codeup.models;

import javax.persistence.*;

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

	@Column(nullable = false, length = 120)
	private String title;

	@Column(nullable = false, columnDefinition = "text")
	private String text;

	@OneToOne
	private User user;

	public Post(String title, String text) {
		this.title = title;
		this.text = text;
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
}
