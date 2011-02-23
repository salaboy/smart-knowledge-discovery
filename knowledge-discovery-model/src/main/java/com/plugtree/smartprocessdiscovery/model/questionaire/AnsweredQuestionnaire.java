package com.plugtree.smartprocessdiscovery.model.questionaire;

import java.util.HashMap;
import java.util.Map;

public class AnsweredQuestionnaire {
	
	private Questionnaire questionnaire;
	
	private Map<Question, Answer> answers;
	
	public AnsweredQuestionnaire() {
		
	}
	
	public AnsweredQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	
	public void addAnswer(Answer answer) {
		if(answers==null) {
			answers = new HashMap<Question, Answer>();
		}
		
		Question question = answer.getQuestion();
		
		if(questionnaire.getQuestions().contains(question)) {
			answers.put(question, answer);
		}
	}
	
	public void removeAnswer(Question question) {
		if(answers!=null) {
			answers.remove(question);
		}
	}
	
	public Answer getAnswer(Question question) {
		if(answers==null) {
			return null;
		} else {
			return answers.get(question);
		}
	}

}
