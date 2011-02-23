package com.wordpress.salaboy.smartknowledgediscovery.util;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlType;

/**
 * Utility class for representing a {@link RestDataSource} request as an object.
 * 
 * @see http://www.smartclient.com/docs/7.0rc2/a/b/c/go.html#class..RestDataSource
 */
@XmlType
@MappedSuperclass
public abstract class DSRequest {

	private String dataSource;
	private OperationType operationType;
	private int startRow;
	private int endRow;	
	private String componentId;
	
	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSource() {
		return dataSource;
	}
}
