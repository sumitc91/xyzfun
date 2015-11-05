package com.funoverflowwebservices.common.core.vo;

import java.util.List;

public class SolrInsertImageEntity {

	private String id;
	private String title;
	private String description;
	private String author;
	private List<String> tags;
	private String tagsString;
	private String imageurl_l;
	private String last_modified;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
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
	public String getTagsString() {
		return tagsString;
	}
	public void setTagsString(String tagsString) {
		this.tagsString = tagsString;
	}
	@Override
	public String toString() {
		return "SolrInsertImageEntity [id=" + id + ", title=" + title
				+ ", description=" + description + ", author=" + author
				+ ", tags=" + tags + ", tagsString=" + tagsString
				+ ", imageurl_l=" + imageurl_l + ", last_modified="
				+ last_modified + "]";
	}
	
	
}
