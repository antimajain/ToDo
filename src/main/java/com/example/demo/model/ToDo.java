package com.example.demo.model;

import java.util.Date;
import org.springframework.data.annotation.Id;

public class ToDo {

	@Id
	private String id;
	private String description;
	private Date createdDate = new Date();
	private boolean completed = false;
	private boolean archive = false;

	public ToDo() {

	}

	public ToDo(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + ", createdDate=" + createdDate + ", completed="
				+ completed + ", archive=" + archive + "]";
	}

	

}
