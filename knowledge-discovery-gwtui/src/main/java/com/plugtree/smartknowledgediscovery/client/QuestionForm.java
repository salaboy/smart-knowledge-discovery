package com.plugtree.smartknowledgediscovery.client;

import java.util.HashMap;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.plugtree.smartprocessdiscovery.model.questionaire.Question;

public class QuestionForm extends Grid {

    HashMap<String, TextBox> data = new HashMap<String, TextBox>();

    public QuestionForm(QuestionDataSource questionDataSource) {

        resize(questionDataSource.getTableHeader().size(), 2);

        int row = 0;

        for (String header : questionDataSource.getTableHeader()) {

            TextBox textBox = new TextBox();

            setWidget(row, 0, new Label(header));
            setWidget(row, 1, textBox);

            data.put(header, textBox);

            row++;
        }
    }

    public Question getQuestion() {

        Question question = new Question();

        question.setId(Long.parseLong(data.get("Id").getText()));
        question.setText(data.get("Text").getText());
        question.setNotes(data.get("Notes").getText());

        return question;
    }
}
