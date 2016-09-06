package edu.curso.java.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.curso.java.bo.Proyecto;

@Repository
public class ProyectoDAOImp implements ProyectoDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public Long guardarProyecto(Proyecto proyecto) {
		return (Long) sessionFactory.getCurrentSession().save(proyecto);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> listarProyectos() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Proyecto");
        return query.list();
	}

}
