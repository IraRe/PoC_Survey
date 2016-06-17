package com.prodyna.ted11.ciss.survey.controller;

import java.util.ArrayList;
import java.util.Collection;
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

import com.prodyna.ted11.ciss.survey.entity.FilledSurvey;
import com.prodyna.ted11.ciss.survey.entity.Survey;
import com.prodyna.ted11.ciss.survey.entity.UserAnswer;
import com.prodyna.ted11.ciss.survey.repository.AnswerRepository;
import com.prodyna.ted11.ciss.survey.repository.SurveyRepository;

@RestController
public class FilledSurveyRestController {

	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired 
	private AnswerRepository answerRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/filled")
	public List<FilledSurvey> getAllSurveys() {
		List<FilledSurvey> allFilledSurveys = new ArrayList<>();
		List<Survey> allSurveys = surveyRepository.findAll();
		for (Survey survey : allSurveys) {
			List<UserAnswer> userAnswers = answerRepository.findAllBySurveyName(survey.getName());
			FilledSurvey filledSurvey = new FilledSurvey(survey, userAnswers);
			allFilledSurveys.add(filledSurvey);
		}
		return allFilledSurveys;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/filled")
	public HttpEntity<FilledSurvey> saveSurvey(@RequestBody FilledSurvey filledSurvey) {
		Collection<UserAnswer> userAnswers = filledSurvey.getUserAnswers();
		List<UserAnswer> savedAnswers = answerRepository.save(userAnswers);
		FilledSurvey savedSurvey = new FilledSurvey(filledSurvey.getSurvey(), savedAnswers);
		return new ResponseEntity<FilledSurvey>(savedSurvey, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/filled/{id}")
	public HttpEntity<FilledSurvey> getFulledSurveyById(@PathVariable Long id) {
		FilledSurvey filledSurvey = new FilledSurvey();
		Survey survey = surveyRepository.findById(id);
		filledSurvey.setSurvey(survey);
		List<UserAnswer> userAnswers = answerRepository.findAllBySurveyName(survey.getName());
		filledSurvey.setUserAnswers(userAnswers);
		return new ResponseEntity<FilledSurvey>(filledSurvey, HttpStatus.OK);
	}
	
}
