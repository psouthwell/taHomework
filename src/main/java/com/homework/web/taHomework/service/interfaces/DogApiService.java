package com.homework.web.taHomework.service.interfaces;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface DogApiService {

	public String getListAllBreeds() throws ClientProtocolException, IOException;

	public String getRandomImage() throws ClientProtocolException, IOException;

	public String getBreedImages(String breedname) throws ClientProtocolException, IOException;

	public String getBreedImagesRandom(String breedname) throws ClientProtocolException, IOException;

	public String getAllSubBreeds(String breedname) throws ClientProtocolException, IOException;

}