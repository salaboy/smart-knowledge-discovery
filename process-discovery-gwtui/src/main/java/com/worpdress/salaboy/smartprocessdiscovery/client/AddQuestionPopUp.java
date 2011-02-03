package com.worpdress.salaboy.smartprocessdiscovery.client;

import com.google.gwt.user.client.ui.PopupPanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class AddQuestionPopUp extends PopupPanel {

	private VLayout popUpContent = new VLayout();
	private HLayout buttonLayout = new HLayout();
	private DynamicForm form = new DynamicForm();
	
	private IButton addButton = new IButton("Add");
	private IButton cancelButton = new IButton("Cancel");
	
	public AddQuestionPopUp(DataSource dataSource, ListGrid list) {
		
		form.setIsGroup(true);
		form.setDataSource(dataSource);
		
		if (list != null) {
			form.editSelectedData(list);
			form.setGroupTitle("Edit");
		} else {
			form.setGroupTitle("Add");
		}
		
		center();
		setModal(true);
		
		buttonLayout.setMembers(addButton, cancelButton);
		
		popUpContent.addMember(form);
		popUpContent.addMember(buttonLayout);
		add(popUpContent);		
		
		addButton.addClickHandler(new ClickHandler() {

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
