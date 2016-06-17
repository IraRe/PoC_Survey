/**
 * 
 */
package com.prodyna.ted11.ciss.survey.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Entity
public class UserAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Question questionAnswered;
	
	private String userId;
	
	private String surveyName;
	
	private String answerText;

	public Question getQuestionAnswered() {
		return questionAnswered;
	}

	public void setQuestionAnswered(Question questionAnswered) {
		this.questionAnswered = questionAnswered;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((questionAnswered == null) ? 0 : questionAnswered.hashCode());
		result = prime * result + ((surveyName == null) ? 0 : surveyName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAnswer other = (UserAnswer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (questionAnswered == null) {
			if (other.questionAnswered != null)
				return false;
		} else if (!questionAnswered.equals(other.questionAnswered))
			return false;
		if (surveyName == null) {
			if (other.surveyName != null)
				return false;
		} else if (!surveyName.equals(other.surveyName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAnswer [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (questionAnswered != null) {
			builder.append("questionAnswered=");
			builder.append(questionAnswered);
			builder.append(", ");
		}
		if (userId != null) {
			builder.append("uuid=");
			builder.append(userId);
			builder.append(", ");
		}
		if (surveyName != null) {
			builder.append("surveyName=");
			builder.append(surveyName);
		}
		builder.append("]");
		return builder.toString();
	}

}
