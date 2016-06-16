/**
 * 
 */
package com.prodyna.ted11.ciss.survey.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Entity
@DiscriminatorValue(value="M")
public class MultiplechoiceQuestion extends Question {
	
	{
		super.questionType = QuestionType.MULTIPLECHOICE;
	}
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private AnswerOption answer;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<AnswerOption> answerOptions;

	public AnswerOption getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerOption answer) {
		this.answer = answer;
	}

	public Collection<AnswerOption> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(Collection<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((answerOptions == null) ? 0 : answerOptions.hashCode());
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
		MultiplechoiceQuestion other = (MultiplechoiceQuestion) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answerOptions == null) {
			if (other.answerOptions != null)
				return false;
		} else if (!answerOptions.equals(other.answerOptions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MultiplechoiceQuestion [");
		if (answer != null) {
			builder.append("answer=");
			builder.append(answer);
			builder.append(", ");
		}
		if (answerOptions != null) {
			builder.append("answerOptions=");
			builder.append(answerOptions);
		}
		builder.append("]");
		return builder.toString();
	}

}
