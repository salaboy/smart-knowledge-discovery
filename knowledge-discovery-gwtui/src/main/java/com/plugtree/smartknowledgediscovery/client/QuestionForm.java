package com.plugtree.smartknowledgediscovery.client;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionForm extends Grid {

    HashMap<Field, TextBox> dataValidation = new HashMap<Field, TextBox>();
    HashMap<String, TextBox> data = new HashMap<String, TextBox>();

    public QuestionForm(QuestionDataSource questionDataSource) {

        resize(questionDataSource.getFields().size(), 2);

        int row = 0;

        for (Field field : questionDataSource.getFields()) {

            TextBox textBox = new TextBox();

            setWidget(row, 0, new Label(field.getName()));
            setWidget(row, 1, textBox);

            dataValidation.put(field, textBox);
            data.put(field.getName(), textBox);

            row++;
        }
    }

    public Question getQuestion() {

        for (Field field : dataValidation.keySet()) {
            if (!field.isValid(dataValidation.get(field).getText())) {
                System.out.println("No valid question!");
            }            
        }

        Question question = new Question();

        question.setId(Long.parseLong(data.get("Id").getText()));
        question.setText(data.get("Text").getText());
        question.setNotes(data.get("Notes").getText());

        return question;
    }
}
