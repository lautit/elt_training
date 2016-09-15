package edu.curso.java.capadatos.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.capadatos.bo.Persona;

@Repository
public class PersonaDAOHibernate implements PersonaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public long guardarNuevaPersona(Persona persona) {
		return (Long) sessionFactory.getCurrentSession().save(persona);
	}

	public List<Persona> recuperarPersona() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Persona").list();
	}

	public void actualizarPersona(Persona persona) {
		sessionFactory.getCurrentSession().update(persona);		
	}

	public void borrarPersona(long idPersona) {
		Persona persona = buscarPersonaPorId(idPersona);
		sessionFactory.getCurrentSession().delete(persona);
	}

	public Persona buscarPersonaPorId(long idPersona) {
		return (Persona) sessionFactory.getCurrentSession().get(Persona.class, idPersona);
	}

}
