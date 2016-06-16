package com.prodyna.ted11.ciss.survey;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prodyna.ted11.ciss.survey.entity.AnswerOption;
import com.prodyna.ted11.ciss.survey.entity.FreetextQuestion;
import com.prodyna.ted11.ciss.survey.entity.MultiplechoiceQuestion;
import com.prodyna.ted11.ciss.survey.entity.Question;
import com.prodyna.ted11.ciss.survey.entity.Survey;
import com.prodyna.ted11.ciss.survey.repository.SurveyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CissSurveyApplication.class)
public class CissSurveyApplicationTests {
	
	@Autowired
	SurveyRepository surveyRepository;

	@Test
	public void contextLoads() {
		Survey surveyInput = new Survey();
		surveyInput.setName("MySurvey");
		ArrayList<Question> questions = new ArrayList<>();
		FreetextQuestion freetextQuestion = new FreetextQuestion();
		freetextQuestion.setQuestionText("In welchem Land wurde Baseball erfunden?");
		freetextQuestion.setAnswer("Ukraine");
		questions.add(freetextQuestion);
		MultiplechoiceQuestion multiplechoiceQuestion = new MultiplechoiceQuestion();
		multiplechoiceQuestion.setQuestionText("Wann wurde die erste Verfassung der Welt verfasst?");
		Collection<AnswerOption> answerOptions = new ArrayList<>();
		AnswerOption answer1 = new AnswerOption();
		answer1.setAnswerText("1921");
		answerOptions.add(answer1);
		AnswerOption answer2 = new AnswerOption();
		answer2.setAnswerText("712");
		answerOptions.add(answer2);
		AnswerOption answer3 = new AnswerOption();
		answer3.setAnswerText("2016");
		answerOptions.add(answer3);
		multiplechoiceQuestion.setAnswer(answer1);
		multiplechoiceQuestion.setAnswerOptions(answerOptions);
		questions.add(multiplechoiceQuestion);
		surveyInput.setQuestions(questions);
		Survey survey = surveyRepository.save(surveyInput);
		Assert.assertNotNull(survey.getId());
	}

}
