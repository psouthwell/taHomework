package com.homework.web.taHomework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BreedViewCount {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int viewCount;
	
	
	
	
	public BreedViewCount() {
		super();
	}


	public BreedViewCount(Long id, String name, int viewCount) {
		super();
		this.id = id;
		this.name = name;
		this.viewCount = viewCount;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getViewCount() {
		return viewCount;
	}


	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
}
