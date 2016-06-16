package com.prodyna.ted11.ciss.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.prodyna.ted11.ciss.survey.repository.SurveyRepository;

@RestController
public class SurveyRestController {

	@Autowired
	private SurveyRepository surveyRepository;
	
	public void getSurvey() {
		
	}
}
