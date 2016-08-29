package edu.curso.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SoyUnComponent {

	private String texto;
	
	@Autowired
	private Persona persona;

	public SoyUnComponent() {
		System.out.println("Creando un Component");
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void saludar() {
		System.out.println("Ejecutando saludar: " + texto + " " + persona.getNombre());
	}

}
