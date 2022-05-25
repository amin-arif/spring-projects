package com.arif.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arif.spring.data.jpa.entity.Tutorial;

// The interface example is for Native Query

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	
	List<Tutorial> findAll();
	
	@Query(value = "SELECT * FROM tutorial t WHERE t.published = ?1", nativeQuery = true)
	List<Tutorial> findByPublished(boolean isPublished);
	
	@Query(value = "SELECT * FROM tutorial t WHERE t.title LIKE %?1%", nativeQuery = true)
	List<Tutorial> findByTitleLike(String title);
	
	@Query(value = "SELECT * FROM tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1, '%'))", nativeQuery = true)
	List<Tutorial> findByTitleLikeCaseInsensitive(String title);
	
}
