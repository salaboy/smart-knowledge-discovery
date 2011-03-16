package com.worpdress.salaboy.smartprocessdiscovery.client;

import java.util.List;

public interface DataSource<T> {	
		
		public List<T> getList();		
		public List<String> getTableHeader();		

}
