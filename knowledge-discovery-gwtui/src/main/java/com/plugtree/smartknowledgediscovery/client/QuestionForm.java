package com.plugtree.smartknowledgediscovery.client;

import java.util.HashMap;
import java.util.LinkedList;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionForm extends Grid {

    HashMap<String, SmartTextBox> data = new HashMap<String, SmartTextBox>();
    boolean isEditQuestionForm = true;

    LinkedList<String> errors = new LinkedList<String>(); 

    public QuestionForm(QuestionDataSource questionDataSource, Question question) {

        if (question == null) {
            isEditQuestionForm = false;
        }

        resize(questionDataSource.getFields().size(), 2);

        int row = 0;

        for (Field field : questionDataSource.getFields()) {

            if (field.isKey() &&  !isEditQuestionForm) {
                continue;
            }

            SmartTextBox textBox = new SmartTextBox(field);

            setWidget(row, 0, new Label(field.getName()));
            setWidget(row, 1, textBox);

            data.put(field.getName(), textBox);

            row++;
        }

        if (isEditQuestionForm) {
            data.get("Id").setText(question.getId().toString());
            data.get("Text").setText(question.getText());
            data.get("Notes").setText(question.getNotes());
        }
    }

    public Question getQuestion() {

        Question question = new Question();

        if (isEditQuestionForm) {
            question.setId(Long.parseLong(data.get("Id").getText()));
        }

        question.setText(data.get("Text").getText());
        question.setNotes(data.get("Notes").getText());

        return question;
    }

    public boolean isDataValid() {

        boolean valid = true;
        errors.clear();

        for (String fieldName : data.keySet()) {

            SmartTextBox textBox = data.get(fieldName);

            if (!textBox.isContentValid()) {
                errors.add(textBox.getValidationError());
                valid = false;
            }
        }

        return valid;
    }

    public LinkedList<String> getValidationErrors() {
        return errors;
    }
}
