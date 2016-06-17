package com.prodyna.ted11.ciss.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodyna.ted11.ciss.survey.entity.UserAnswer;

public interface AnswerRepository extends JpaRepository<UserAnswer, Long> {

	public List<UserAnswer> findAllBySurveyName(String surveyName);
}
