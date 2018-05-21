package com.homework.web.taHomework.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.web.taHomework.domain.Breed;
import com.homework.web.taHomework.domain.BreedViewCount;
import com.homework.web.taHomework.domain.BreedViewCountRepository;
import com.homework.web.taHomework.service.interfaces.BreedService;
import com.homework.web.taHomework.service.interfaces.DogApiService;



@Service
public class BreedServiceImpl implements BreedService {

	@Autowired
	private DogApiService dogApiService;
	
	@Autowired
	private BreedViewCountRepository breedViewCountRepository;
	
	
	public void saveBreedViewCount(BreedViewCount breedViewCount) {
		
		this.breedViewCountRepository.save(breedViewCount);
		
	}
	
	public BreedViewCount findBreedViewCountByName(String name) {
		return breedViewCountRepository.findByName(name);
	}
	
	
	public List<Breed> getAllBreeds() throws Exception {
		List<Breed> breedList = new ArrayList<Breed>();
		String jsonListAllBreeds;
		
		try {
			jsonListAllBreeds = this.dogApiService.getListAllBreeds();
		} catch (Throwable e) {
			throw new Exception(e);
		}
		
		
		JsonReader jsonReader = Json.createReader(new StringReader(jsonListAllBreeds));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		
		
		String status = jsonObject.getString("status");
		
		if( "success".equalsIgnoreCase(status) ) {
			JsonObject message = jsonObject.getJsonObject("message");
			message.entrySet().forEach(item-> {
				String breedName = item.getKey();
				JsonArray jsonArray = (item.getValue() instanceof JsonArray ) ? (JsonArray) item.getValue() : Json.createArrayBuilder().build();
				List<String> subBreeds = new ArrayList<String>();
				jsonArray.forEach(value->{
					subBreeds.add(value.toString());
				});
				
				
				breedList.add( new Breed(breedName, subBreeds ) );
			});
			
			
		}
		
		return breedList;
	}
	
	
	
	public List<String> getAllBreedImages(String breedname) throws Exception {
		List<String> breedList = new ArrayList<String>();
		String jsonListAllBreeds;
		
		try {
			jsonListAllBreeds = this.dogApiService.getBreedImages(breedname);
		} catch (Throwable e) {
			throw new Exception(e);
		}
		
		
		JsonReader jsonReader = Json.createReader(new StringReader(jsonListAllBreeds));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		
		
		String status = jsonObject.getString("status");
		
		if( "success".equalsIgnoreCase(status) ) {
			JsonArray message = jsonObject.getJsonArray("message");
			message.forEach(value->{
				breedList.add(value.toString());
			});
						
		}
		
		return breedList;
	}
	
	
	public List<String> getBreedImagesInRange(String breedname, int skip, int size) throws Exception {
		List<String> allBreedImageList =this.getAllBreedImages(breedname);
		List<String> breedImageList = new ArrayList<String>();
		
		for( int i = skip; i < allBreedImageList.size(); ++ i ) {
			if( breedImageList.size() < size ) {
				breedImageList.add( allBreedImageList.get(i) );
			} else {
				break;
			}
			
			
		}
		
		
		
		return breedImageList;
	}

	
}
