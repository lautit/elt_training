package edu.curso.java.dao;

import java.util.List;

import edu.curso.java.bo.Proyecto;

public interface ProyectoDAO {

	public Long guardarProyecto(Proyecto proyecto);
	public List<Proyecto> listarProyectos();
	
	
}
