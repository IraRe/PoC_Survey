package com.prodyna.ted11.ciss.survey.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private QuestionType questionType;
	
	private String questionText;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<AnswerOption> answerOptions;

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Collection<AnswerOption> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(Collection<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerOptions == null) ? 0 : answerOptions.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
		result = prime * result + ((questionType == null) ? 0 : questionType.hashCode());
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
		Question other = (Question) obj;
		if (answerOptions == null) {
			if (other.answerOptions != null)
				return false;
		} else if (!answerOptions.equals(other.answerOptions))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		if (questionType != other.questionType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (questionType != null) {
			builder.append("questionType=");
			builder.append(questionType);
			builder.append(", ");
		}
		if (questionText != null) {
			builder.append("questionText=");
			builder.append(questionText);
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
