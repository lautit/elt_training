package edu.curso.java.services;

import java.util.List;

import edu.curso.java.bo.Proyecto;

public interface ProyectoService {

	Long guardarProyecto(Proyecto proyecto);

	List<Proyecto> listarProyectos();

}