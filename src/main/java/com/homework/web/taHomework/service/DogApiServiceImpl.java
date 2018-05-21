package com.homework.web.taHomework.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Service;

import com.homework.web.taHomework.service.interfaces.DogApiService;
import com.homework.web.util.HttpUtils;

@Service
public class DogApiServiceImpl implements DogApiService {

    private final static String dogCeoApiRoot = "https://dog.ceo/api/";
		
    public static String writeDogApiServiceError(Throwable e) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JsonGenerator jsonGenerator = Json.createGenerator(bos);
		
		jsonGenerator.writeStartObject();
		jsonGenerator.write("status", "Error");
		jsonGenerator.write("message", "Error: " + e.getMessage() );
		jsonGenerator.writeEnd();  
		jsonGenerator.close();
		
		String json = bos.toString();
		return json;
	}

    
    @Override
	public String getListAllBreeds() throws ClientProtocolException, IOException {
    	String url = DogApiServiceImpl.dogCeoApiRoot + "breeds/list/all";
    	String returnContent = HttpUtils.getUrlContentsAsString(url);
    	return returnContent;
    }
    

	@Override
	public String getRandomImage() throws ClientProtocolException, IOException {
		String url = DogApiServiceImpl.dogCeoApiRoot + "breeds/image/random";
    	String returnContent = HttpUtils.getUrlContentsAsString(url);
    	return returnContent;
    }


	@Override
	public String getBreedImages(String breedname) throws ClientProtocolException, IOException {
		String url = DogApiServiceImpl.dogCeoApiRoot + "breed/" + breedname + "/images";
    	String returnContent = HttpUtils.getUrlContentsAsString(url);
    	return returnContent;
    }

	@Override
	public String getBreedImagesRandom(String breedname) throws ClientProtocolException, IOException {
		String url = DogApiServiceImpl.dogCeoApiRoot + "breed/" + breedname + "/images/random";
    	String returnContent = HttpUtils.getUrlContentsAsString(url);
    	return returnContent;
    }
	
	@Override
	public String getAllSubBreeds(String breedname) throws ClientProtocolException, IOException {
		String url = DogApiServiceImpl.dogCeoApiRoot + "breed/" + breedname + "/list";
    	String returnContent = HttpUtils.getUrlContentsAsString(url);
    	return returnContent;
    }


    
}
