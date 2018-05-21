package com.homework.web.taHomework.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homework.web.taHomework.domain.Breed;
import com.homework.web.taHomework.service.DogApiServiceImpl;
import com.homework.web.taHomework.service.interfaces.BreedService;
import com.homework.web.taHomework.service.interfaces.DogApiService;


@CrossOrigin
@RestController
public class BreedServiceController {

	final static Logger logger = Logger.getLogger(BreedServiceController.class);
	
	
	@Autowired
	private BreedService breedService;
	

	/**
	 * Get all breeds
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/breedservice/list")
    public List<Breed> getListAllBreeds() throws Exception {
    	return this.breedService.getAllBreeds();
	}
    
    
    
    /**
     * Get a range of images for a given breed name
     * 
     * @param breedname
     * @param skip
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/breedservice/{breedname}/images/range")
    public List<String> getAllBreedImagesByNameAndRange(@PathVariable("breedname") String breedname, @RequestParam(value="skip") int skip, @RequestParam(value="size") int size) throws Exception {
    	return this.breedService.getBreedImagesInRange(breedname, skip, size);
	}
  
    /**
     * Get all images a Breed Has
     * @param breedname
     * @return
     * @throws Exception
     */
    @RequestMapping("/breedservice/{breedname}/images")
    public List<String> getAllBreedImagesByNameAndRange(@PathVariable("breedname") String breedname) throws Exception {
    	return this.breedService.getAllBreedImages(breedname);
	}
	
}
