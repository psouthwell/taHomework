package com.homework.web.taHomework.domain;

import java.util.List;

public class Breed {

    private String breed;
    private List<String> subBreeds;
    
    public Breed() {
    	
    }
    
    public Breed(String breed, List<String> subBreeds) {
       this.breed = breed;
       this.subBreeds = subBreeds;
    }

    public void setBreed(String breed) {
    	this.breed = breed;
    }
    
	public String getBreed() {
		return breed;
	}

	public List<String> getSubBreeds() {
		return subBreeds;
	}

	public void setSubBreeds(List<String> subBreeds) {
		this.subBreeds = subBreeds;
	}

	
}
