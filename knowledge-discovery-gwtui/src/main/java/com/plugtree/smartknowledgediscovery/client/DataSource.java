package com.plugtree.smartknowledgediscovery.client;


public interface DataSource<T> {
	public boolean fetch();
	public boolean add(T element);
	public boolean remove(long id);
	public boolean update(T element);
}
