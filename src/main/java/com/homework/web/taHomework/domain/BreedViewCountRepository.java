package com.homework.web.taHomework.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedViewCountRepository extends JpaRepository<BreedViewCount, Long>{
	public BreedViewCount findByName(String name);
	
}
