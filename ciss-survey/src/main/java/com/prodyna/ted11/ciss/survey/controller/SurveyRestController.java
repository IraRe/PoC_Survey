package com.prodyna.ted11.ciss.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/survey")
	public HttpEntity<Survey> saveSurvey(@RequestBody Survey survey) {
		Survey savedSurvey = surveyRepository.save(survey);
		return new ResponseEntity<Survey>(savedSurvey, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/survey/{id}")
	public HttpEntity<Survey> getSurveyById(@PathVariable Long id) {
		Survey survey = surveyRepository.findById(id);
		return new ResponseEntity<Survey>(survey, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/survey/current")
	public HttpEntity<Survey> getCurrentSurvey() {
		Survey survey = surveyRepository.findTopByOrderByIdDesc();
		return new ResponseEntity<Survey>(survey, HttpStatus.OK);
	}
	
}
