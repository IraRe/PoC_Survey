package com.prodyna.ted11.ciss.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodyna.ted11.ciss.survey.entity.Survey;
import com.prodyna.ted11.ciss.survey.repository.SurveyRepository;

@RestController
public class SurveyRestController {

	@Autowired
	private SurveyRepository surveyRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/survey")
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = surveyRepository.findAll();
		return allSurveys;
	}
	
	
}
