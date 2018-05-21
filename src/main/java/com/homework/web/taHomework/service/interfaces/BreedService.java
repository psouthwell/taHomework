package com.homework.web.taHomework.service.interfaces;

import java.util.List;

import com.homework.web.taHomework.domain.Breed;

public interface BreedService {

	List<Breed> getAllBreeds() throws Exception;
	List<String> getAllBreedImages(String breedname) throws Exception;
	List<String> getBreedImagesInRange(String breedname, int skip, int size) throws Exception;
	

}