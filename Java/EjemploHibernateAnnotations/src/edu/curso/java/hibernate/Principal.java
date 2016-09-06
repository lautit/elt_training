package edu.curso.java.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.curso.java.hibernate.bo.Cliente;
import edu.curso.java.hibernate.bo.Direccion;

public class Principal {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		System.out.println("Ejecutando guardar");
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		Direccion direccion = new Direccion();
//		direccion.setCalle("Calle Falsa 123");
//		direccion.setCp("AB1234CD");
//		
//		session.save(direccion);
//		System.out.println("Id generado " + direccion.getId());
//		
//		Cliente cliente = new Cliente();
//
//		double saldo = 5000;		
//		cliente.setNombre("Juan");
//		cliente.setApellido("Perez");
//		cliente.setEsClienteVip(true);
//		cliente.setSaldo(saldo);
//		cliente.setFechaAlta(new Date());
//		cliente.setDireccion(direccion);
//
//		session.save(cliente);
//		System.out.println("Id generado " + cliente.getId());
		
		Query query = session.createQuery("from Cliente");
		
		List<Cliente> clientes = query.list();
		
		for(Cliente cliente : clientes) {
			System.out.println(cliente.getApellido() + ", " + cliente.getNombre());
			System.out.println(cliente.getDireccion() != null ? cliente.getDireccion().getCalle() : "");
		}
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
	}
	
	
}
