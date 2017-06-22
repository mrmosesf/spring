package com.codeup.models;

/**
 * Created by Moses Franco on 6/20/17
 * Codeup
 * Pinnacles
 */
public class Post {
	private long id;
	private String title;
	private String text;

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
