package edu.evalucion.java.dao.exceptions;

@SuppressWarnings("serial")
public class GestorDePedidosException extends Exception {
	
	public GestorDePedidosException(String message) {
		super(message);
	}
	
	public GestorDePedidosException(String message, Throwable exception) {
		super(message, exception);
	}
	
}