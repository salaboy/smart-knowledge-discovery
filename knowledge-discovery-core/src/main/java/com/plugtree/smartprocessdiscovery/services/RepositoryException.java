package com.plugtree.smartprocessdiscovery.services;

public class RepositoryException extends Exception {

	private static final long serialVersionUID = 3801504970286404263L;
	
	public RepositoryException(String message) {
		super(message);
	}
	
	public RepositoryException(String message, Throwable ex) {
		super(message, ex);
	}

}
