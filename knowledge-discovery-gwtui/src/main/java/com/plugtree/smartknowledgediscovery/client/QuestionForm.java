package com.plugtree.smartknowledgediscovery.client;

import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionForm extends Form<Question> {

    private boolean isEditForm = false;

    public QuestionForm(Question question) {

        if (question != null) {
            isEditForm = true;
        }

        setUp(QuestionDataSource.getInstance(), isEditForm);

        if (question != null) {
            data.get("Id").setText(question.getId().toString());
            data.get("Text").setText(question.getText());
            data.get("Notes").setText(question.getNotes());
        }
    }

    public Question getQuestion() {

        Question question = new Question();

        if (isEditForm) {
            question.setId(Long.parseLong(data.get("Id").getText()));
        }

        question.setText(data.get("Text").getText());
        question.setNotes(data.get("Notes").getText());

        return question;
    }

}
