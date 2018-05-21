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
	

    /**
     * The reason Im using a WRTIER here is the breeds are basically the fields of Message (in the JSON).
     * That makes that an ugly structure in Java because Im assuming other dog breads might be created by
     * Science (They change), etc...  
     * 
     *  So to me.. It's easier to try to write it.. Rather then Model it in Java as a static field set.
     * @param name
     * @return   Json Object sith {   "status": "success/fail",
     *                                "message":  {
     *                             			"breed1", [],
     *                                      "breed2", [ "subbreed_a", subreed_b" ],
     *                                      etc.....  (one for every breed that exists.. Whos value is empty.. or a list
     *                                                 of sub breeds).
     *                                }
     *                                
     *                            }
     *                            
     *  @see https://dog.ceo/api/breeds/list/all
     *  
     *  
     *  @note I would have put this in the service.. But I feel like the JSON is really contrived for the purpose 
     *        of the format tailored for the dog.ceo api.
     */
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
