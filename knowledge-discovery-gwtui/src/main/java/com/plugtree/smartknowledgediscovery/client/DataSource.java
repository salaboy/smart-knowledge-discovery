package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

public interface DataSource<T> {
	public List<T> getList();
	
	public List<String> getTableHeader();
	

}
