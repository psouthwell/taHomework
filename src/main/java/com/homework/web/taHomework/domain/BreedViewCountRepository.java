package com.homework.web.taHomework.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedViewCountRepository extends JpaRepository<BreedViewCount, Long>{
	
	BreedViewCount findByName(String name);
	
	List<BreedViewCount> findTop10ByOrderByViewCountDesc();
	
	
}
