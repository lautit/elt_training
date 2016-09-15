package edu.curso.java.capadatos.dao;

import edu.curso.java.capadatos.bo.*;
import java.util.*;

public interface PersonaDAO {

	public long guardarNuevaPersona(Persona persona);
	public Persona buscarPersonaPorId(long idPersona);
	public void actualizarPersona(Persona persona);
	public void borrarPersona(long idPersona);
	public List<Persona> recuperarPersona();
}
