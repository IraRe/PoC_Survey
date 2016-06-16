/**
 * 
 */
package com.prodyna.ted11.ciss.survey.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Entity
@DiscriminatorValue(value="F")
public class FreetextQuestion extends Question {
	
	{
		super.questionType = QuestionType.FREETEXT;
	}
	
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreetextQuestion other = (FreetextQuestion) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FreetextQuestion [");
		if (answer != null) {
			builder.append("antwort=");
			builder.append(answer);
		}
		builder.append("]");
		return builder.toString();
	}
	
}
