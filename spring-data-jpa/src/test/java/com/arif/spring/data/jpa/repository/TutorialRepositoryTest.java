package com.arif.spring.data.jpa.repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arif.spring.data.jpa.entity.Tutorial;

@SpringBootTest
public class TutorialRepositoryTest {
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	@Test
	public void insertTutorial() {
		
		Tutorial tutorial = new Tutorial(
					"Asian tiger",
					"Bangladesh is a next asian tiger",
					3,
					true,
					new Date()
				);
		
		tutorialRepository.save(tutorial);
	}
	
	@Test
	public void findAll() {
		List<Tutorial> tutorials = tutorialRepository.findAll();		
		System.out.println("All tutorials: " + tutorials);
	}
	
	@Test
	public void findByPublished() {
		List<Tutorial> tutorials = tutorialRepository.findByPublished(true);		
		System.out.println("Published tutorials: " + tutorials);
	}
	
	@Test
	public void findByTitle() {
		List<Tutorial> tutorials = tutorialRepository.findByTitleLike("Hello");		
		System.out.println("Case sensitive tutorials: " + tutorials);
		
		List<Tutorial> tutorials2 = tutorialRepository.findByTitleLikeCaseInsensitive("");		
		System.out.println("Case sensitive tutorials: " + tutorials2);
	}
}












