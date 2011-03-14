package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.worpdress.salaboy.smartprocessdiscovery.client.questionnaire.QuestionnaireRestDS;

public class AddEditDialog extends Dialog {

	private DynamicForm form = new DynamicForm();	
	
	private IButton okButton = new IButton();
	private IButton cancelButton = new IButton("Cancel");
	
	public AddEditDialog(DataSource dataSource, ListGrid list) {
		
		setIsModal(true);
		setAutoSize(true);
		setToolbarButtons(okButton, cancelButton);

		form.setDataSource(dataSource);
		
		if (list != null) {
			form.editSelectedData(list);
			setTitle("Edit");
			okButton.setTitle("Edit");
		} else {
			setTitle("Add");
			okButton.setTitle("Add");
		}	
		
			addItem(form);
		
		okButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.saveData(new DSCallback() {  
					public void execute(DSResponse response, Object rawData, DSRequest request) {  
						form.editNewRecord();
						hide();
					}  
				});	
			}
		});
		
		cancelButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				hide();				
			}
		});
	}
}