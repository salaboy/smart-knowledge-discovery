package com.plugtree.smartknowledgediscovery.client;

import java.util.List;

public interface DataSource<T> {
	public List<T> getList();	
	public List<String> getTableHeader();
	public boolean fetch();
	public boolean add(T element);
	public boolean remove(long id);
	public boolean update(T element);
}
