package com.prodyna.ted11.ciss.survey.entity;

import java.util.Collection;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public class FilledSurvey {
	
	private Survey survey;
	private Collection<UserAnswer> userAnswers;
	
	public FilledSurvey(Survey survey, Collection<UserAnswer> userAnswers) {
		super();
		this.survey = survey;
		this.userAnswers = userAnswers;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public Collection<UserAnswer> getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(Collection<UserAnswer> userAnswers) {
		this.userAnswers = userAnswers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		result = prime * result + ((userAnswers == null) ? 0 : userAnswers.hashCode());
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
		FilledSurvey other = (FilledSurvey) obj;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		if (userAnswers == null) {
			if (other.userAnswers != null)
				return false;
		} else if (!userAnswers.equals(other.userAnswers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilledSurvey [");
		if (survey != null) {
			builder.append("survey=");
			builder.append(survey);
			builder.append(", ");
		}
		if (userAnswers != null) {
			builder.append("userAnswers=");
			builder.append(userAnswers);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
