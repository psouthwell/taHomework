package com.homework.web.taHomework.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.web.taHomework.service.DogApiServiceImpl;
import com.homework.web.taHomework.service.interfaces.DogApiService;


@CrossOrigin
@Controller
@RestController
public class DogApiController {

	final static Logger logger = Logger.getLogger(DogApiController.class);
	
	
	@Autowired
	private DogApiService dogApiService;
	

   @RequestMapping("/breeds/list/all")
    public String getListAllBreeds() {
    	try {
			String result = dogApiService.getListAllBreeds();
			return result;
		} catch (Throwable e) {
			DogApiController.logger.error("Error exception thrown while calling dogApiService.getListAllBreeds();", e );
			return DogApiServiceImpl.writeDogApiServiceError(e);
		}
    	
    }
    
    @RequestMapping("/breeds/image/random")
    public String getRandomImage() {
    	try {
			String result = dogApiService.getRandomImage();
			return result;
		} catch (Throwable e) {
			DogApiController.logger.error("Error exception thrown while calling dogApiService.getRandomImage();", e );
			return DogApiServiceImpl.writeDogApiServiceError(e);
		}
    	
    }
    
    @RequestMapping("/breed/{breedname}/images")
    public String getBreedImages(@PathVariable("breedname") final String breedname) {
    	try {
			String result = dogApiService.getBreedImages(breedname);
			return result;
		} catch (Throwable e) {
			DogApiController.logger.error("Error exception thrown while calling dogApiService.getBreedImages();", e );
			return DogApiServiceImpl.writeDogApiServiceError(e);
		}
    	
    }
    
    
    @RequestMapping("/breed/{breedname}/images/random")
    public String getBreedImagesRandom(@PathVariable("breedname") final String breedname) {
    	try {
			String result = dogApiService.getBreedImagesRandom(breedname);
			return result;
		} catch (Throwable e) {
			DogApiController.logger.error("Error exception thrown while calling dogApiService.getBreedImagesRandom();", e );
			return DogApiServiceImpl.writeDogApiServiceError(e);
		}
    	
    }
    
    
    @RequestMapping("/breed/{breedname}/list")
    public String getAllSubBreeds(@PathVariable("breedname") final String breedname) {
    	try {
			String result = dogApiService.getAllSubBreeds(breedname);
			return result;
		} catch (Throwable e) {
			DogApiController.logger.error("Error exception thrown while calling dogApiService.getAllSubBreeds();", e );
			return DogApiServiceImpl.writeDogApiServiceError(e);
		}
    	
    }

	
}
