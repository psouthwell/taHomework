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
	public void testTop10BreedViewCount() {
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_10", 10));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_9", 9));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_8", 8));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_7", 7));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_6", 6));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_5", 5));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_4", 4));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_3", 3));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_2", 2));
		this.breedService.saveBreedViewCount(new BreedViewCount(null, "TEST_BREED_1", 1));
		
		
		List<BreedViewCount> top10BreedViewCount = this.breedService.getTop10ViewedBreeds();
		assertNotNull( top10BreedViewCount );
		assertTrue( top10BreedViewCount.size() == 10 );
		assertEquals( 10, top10BreedViewCount.get(0).getViewCount() );
		assertEquals( 1, top10BreedViewCount.get(top10BreedViewCount.size() -1).getViewCount() );
		
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
