package edu.elt.java.bo;

public class Persona {
	
	private Integer idPersona;
	private String nombre;
	private String apellido;
	private Integer edad;
	
	public Persona(String nombre, String apellido, Integer edad) {
		this.idPersona = 0;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public Persona(Integer idPersona, String nombre, String apellido, Integer edad) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public Integer getIdPersona() {
		return idPersona;
	}
	
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
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
	
	public Integer getEdad() {
		return edad;
	}
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "[PERSONA] ID: " + idPersona + " - Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	

}
