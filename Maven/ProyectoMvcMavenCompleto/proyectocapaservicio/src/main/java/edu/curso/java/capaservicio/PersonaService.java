package edu.curso.java.capaservicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.capadatos.bo.Persona;
import edu.curso.java.capadatos.dao.PersonaDAO;

@Service
@Transactional(rollbackFor=Exception.class)
public class PersonaService 
{
	@Autowired
	private PersonaDAO personaDAO;
    
	public long guardarNuevaPersona(Persona persona) {
    	return personaDAO.guardarNuevaPersona(persona);
    }
    
    public List<Persona> recuperarPersonas() {
    	return personaDAO.recuperarPersona();
    }
    
    public Persona buscarPersonaPorId(long idPersona) {
    	return personaDAO.buscarPersonaPorId(idPersona);
    }

	public void borrarPersona(long idPersona) {
		personaDAO.borrarPersona(idPersona);
	}

	public void actualizarPersona(Persona persona) {
		personaDAO.actualizarPersona(persona);
	}

	
}
