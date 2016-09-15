package edu.curso.java.capapresentacion.controladores.form;

import org.hibernate.validator.constraints.NotEmpty;

public class PersonaForm {

	private long id;

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
