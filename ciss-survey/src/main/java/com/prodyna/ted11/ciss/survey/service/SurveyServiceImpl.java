package com.prodyna.ted11.ciss.survey.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodyna.ted11.ciss.survey.entity.Survey;
import com.prodyna.ted11.ciss.survey.repository.SurveyRepository;

@Service
public class SurveyServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	public List<Survey> getAllSurveys() {
		
		return surveyRepository.findAll();
	}
	
	public List<Survey> getAllSurveysDesc() {
		
		return surveyRepository.findAllByOrderByIdDesc();
	}
}
