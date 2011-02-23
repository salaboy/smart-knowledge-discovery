package com.plugtree.smartprocessdiscovery.services;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 3801504970286404263L;
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable ex) {
		super(message, ex);
	}

}
