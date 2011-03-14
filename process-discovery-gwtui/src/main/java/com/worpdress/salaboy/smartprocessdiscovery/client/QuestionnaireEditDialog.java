package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.user.client.ui.TextArea;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class QuestionnaireEditDialog extends Dialog {


	public QuestionnaireEditDialog(){
		QuestionRestDS questionDS = QuestionRestDS.getInstance();
		final DynamicForm form = new DynamicForm();
				
		ButtonItem addQuestion = new ButtonItem("Add-Question");		
		ButtonItem remQuestion = new ButtonItem("Remove-Question");
		TextItem questionnaireName = new TextItem();
		questionnaireName.setTitle("Name");
		ComboBoxItem selectItem = new ComboBoxItem();
		setTitle("New Questionnaire");
		form.setAutoWidth();
		form.setAutoHeight();
		selectItem.setTitle("QuestionId");
		selectItem.setOptionDataSource(questionDS);
		selectItem.setDisplayField("id");
		form.setItems(selectItem,questionnaireName,addQuestion,remQuestion);
		addItem(form);

		setWidth(400);
		setHeight(200);
		
	}		

}
