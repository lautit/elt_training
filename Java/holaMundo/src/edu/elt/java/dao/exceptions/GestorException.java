package edu.elt.java.dao.exceptions;

@SuppressWarnings("serial")
public class GestorException extends Exception {
	
	public GestorException(String message) {
		super(message);
	}
	
	public GestorException(String message, Throwable exception) {
		super(message, exception);
	}
	
}
