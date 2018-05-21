package com.homework.web.taHomework.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.homework.web.taHomework.Application;
import com.homework.web.taHomework.domain.Breed;
import com.homework.web.taHomework.domain.BreedViewCount;
import com.homework.web.taHomework.service.interfaces.BreedService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Application.class})
public class BreedServiceImplTest {

	@Autowired
	BreedService breedService;
	
	
	@Test
	public void testSaveBreedViewCount() {
		BreedViewCount breedViewCount = new BreedViewCount(null, "TEST_BREED", 1);
		
		this.breedService.saveBreedViewCount(breedViewCount);
		
		String expectedName = breedViewCount.getName();
		breedViewCount = this.breedService.findBreedViewCountByName(breedViewCount.getName());
		
		assertTrue( breedViewCount.getId() != null );
		assertTrue( breedViewCount.getId().longValue() > 0 );
		assertEquals( expectedName, breedViewCount.getName() );
	}
	
	@Test
	public void testGetAllBreeds() throws Exception {
		List<Breed> allBreeds = this.breedService.getAllBreeds();
		assertNotNull( allBreeds );
		assertTrue( allBreeds.size() > 0 );
		assertTrue( allBreeds.get(0).getBreed().length() > 0 );
		
	}
	
	
	@Test
	public void testGetAllBreedImages() throws Exception {
		List<String> allBreeds = this.breedService.getAllBreedImages("hound");
		assertNotNull( allBreeds );
		assertTrue( allBreeds.size() > 0 );
	}
	
	
	@Test
	public void testGetBreedImagesInRange() throws Exception {
		final int skip = 100;
		final int rangeSize = 100;
		List<String> allBreedImages = this.breedService.getAllBreedImages("hound");
		assertNotNull( allBreedImages );
		assertTrue( allBreedImages.size() > 0 );
		
		List<String> collectedBreedImages = new ArrayList<String>();
		
		for( int i = 0; true; i += skip ) {
			List<String> imageRange = this.breedService.getBreedImagesInRange("hound", i, rangeSize);
			collectedBreedImages.addAll(imageRange);
			
			if( imageRange.size() < rangeSize ) {
				break;
			}
			
		}
		
		assertEquals( allBreedImages.size(), collectedBreedImages.size() );
		
	}
}
