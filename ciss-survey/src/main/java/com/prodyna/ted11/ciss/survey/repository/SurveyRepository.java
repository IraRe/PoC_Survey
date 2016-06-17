package com.prodyna.ted11.ciss.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodyna.ted11.ciss.survey.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
	
	public Survey findById(Long id);

	public List<Survey> findAllByOrderByIdDesc();
	
	public Survey findTopByOrderByIdDesc();
}
