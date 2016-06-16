package com.prodyna.ted11.ciss.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RestController;

import com.prodyna.ted11.ciss.survey.repository.SurveyRepository;

@RestController
public class SurveyRestController {

	private SurveyRepository surveyRepository;

	@Autowired
	public SurveyRestController(final SurveyRepository surveyRepository) {
		super();
		this.surveyRepository = surveyRepository;
		
	}
}
