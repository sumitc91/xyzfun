package com.funoverflowwebservices.common.request.vo;

import com.funoverflowwebservices.common.core.vo.BaseEntity;

public class NewImageInsertRequestObject extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3595494806965025990L;
	
	private String id;
	private String title;
	private String subject;
	private String description;
	private String comments;
	private String author;
	private String tags;
	private String category;
	private String imagename;
	private int height;
	private int width;
	private String imageurl_s;
	private String imageurl_l;
	private String last_modified;
	private String views;
	private String likes;
	private String dislikes;
	private String username;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageurl_s() {
		return imageurl_s;
	}
	public void setImageurl_s(String imageurl_s) {
		this.imageurl_s = imageurl_s;
	}
	public String getImageurl_l() {
		return imageurl_l;
	}
	public void setImageurl_l(String imageurl_l) {
		this.imageurl_l = imageurl_l;
	}
	public String getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getDislikes() {
		return dislikes;
	}
	public void setDislikes(String dislikes) {
		this.dislikes = dislikes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "NewImageInsertRequestObject [id=" + id + ", title=" + title
				+ ", subject=" + subject + ", description=" + description
				+ ", comments=" + comments + ", author=" + author + ", tags="
				+ tags + ", category=" + category + ", imagename=" + imagename
				+ ", height=" + height + ", width=" + width + ", imageurl_s="
				+ imageurl_s + ", imageurl_l=" + imageurl_l
				+ ", last_modified=" + last_modified + ", views=" + views
				+ ", likes=" + likes + ", dislikes=" + dislikes + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
	
}
