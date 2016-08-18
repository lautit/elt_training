package edu.elt.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.elt.java.DBUtils;
import edu.elt.java.bo.Persona;
import edu.elt.java.dao.exceptions.GestorException;

public class GestorDePersonas {
	
	public void alta(Persona persona)
			throws GestorException {
		Connection connection = null;
		
		try {
			connection = DBUtils.recuperarConexion();
			
			String sql = "INSERT INTO personas (nombre, apellido, edad) "
					+ "VALUES (?, ?, ?);";
			
			PreparedStatement insert = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			insert.setString(1, persona.getNombre());
			insert.setString(2, persona.getApellido());
			insert.setInt(3, persona.getEdad());
			
			insert.executeUpdate();
			
			System.out.println("[GESTOR] alta - SQL: " + insert.toString());
			
			ResultSet generatedKeys = insert.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				Integer idPersona = generatedKeys.getInt(1);
				
				System.out.println("[GESTOR] alta - ID: " + idPersona);
				
				persona.setIdPersona(idPersona);
			}			
		} catch (ClassNotFoundException e) {
			throw new GestorException(
					"[GESTOR] alta(Persona) - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorException(
					"[GESTOR] alta(Persona) - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.cerrarConexion(connection);
		}
	}
	
	public void baja(Integer idPersona)
			throws GestorException {
		Connection connection = null;
		
		try {
			connection = DBUtils.recuperarConexion();
			
			String sql = "DELETE FROM personas "
					+ "WHERE idpersona = ?;";
			
			PreparedStatement delete = connection.prepareStatement(sql);
			
			delete.setInt(1, idPersona);
			
			System.out.println("[GESTOR] baja - SQL: " + delete.toString());
			
			delete.execute();
		} catch (ClassNotFoundException e) {
			throw new GestorException(
					"[GESTOR] baja(idPersona) - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorException(
					"[GESTOR] baja(idPersona) - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.cerrarConexion(connection);
		}
	}
	
	public void actualizar(Persona persona)
			throws GestorException {
		Connection connection = null;
		
		try {
			connection = DBUtils.recuperarConexion();
			
			String sql = "UPDATE personas "
					+ "SET nombre = ?, apellido = ?, edad = ? "
					+ "WHERE idpersona = ?;";
			
			PreparedStatement update = connection.prepareStatement(sql);
			
			update.setString(1, persona.getNombre());
			update.setString(2, persona.getApellido());
			update.setInt(3, persona.getEdad());
			update.setInt(4, persona.getIdPersona());
			
			System.out.println("[GESTOR] actualizar - SQL: " + update.toString());
			
			update.execute();
		} catch (ClassNotFoundException e) {
			throw new GestorException(
					"[GESTOR] actualizar(Persona) - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorException(
					"[GESTOR] actualizar(Persona) - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.cerrarConexion(connection);
		}
	}
	
	public Persona buscar(Integer idPersona)
			throws GestorException {
		Persona persona = null;
		Connection connection = null;
		
		try {
			connection = DBUtils.recuperarConexion();
			
			String sql = "SELECT nombre, apellido, edad "
					+ "FROM personas "
					+ "WHERE idpersona = ?;";
			
			PreparedStatement search = connection.prepareStatement(sql);
			
			search.setInt(1, idPersona);
			
			System.out.println("[GESTOR] buscarPorID - SQL: " + search.toString());
			
			ResultSet encontrado = search.executeQuery();
			
			if(encontrado.next()) {
				persona = new Persona(idPersona,
						encontrado.getString("nombre"),
						encontrado.getString("apellido"),
						encontrado.getInt("edad"));
			}
		} catch (ClassNotFoundException e) {
			throw new GestorException(
					"[GESTOR] buscar(idPersona) - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorException(
					"[GESTOR] buscar(idPersona) - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.cerrarConexion(connection);
		}
		
		return persona;
	}
	
	public ArrayList<Persona> recuperarTodo()
			throws GestorException {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection connection = null;
		
		try {
			connection = DBUtils.recuperarConexion();
			
			String sql = "SELECT idpersona, nombre, apellido, edad "
					+ "FROM personas;";
			
			PreparedStatement searchAll = connection.prepareStatement(sql);
			
			System.out.println("[GESTOR] recuperarTodo - SQL: " + searchAll.toString());
			
			ResultSet encontrado = searchAll.executeQuery();
			
			Integer noPersona = 1;
			
			while(encontrado.next()) {				
				Persona persona = new Persona(
						encontrado.getInt("idpersona"),
						encontrado.getString("nombre"),
						encontrado.getString("apellido"),
						encontrado.getInt("edad"));
				
				System.out.println("[GESTOR] recuperarTodo - Persona " + noPersona + ": " + persona.toString());
				
				personas.add(persona);
				
				noPersona++;
			}
		} catch (ClassNotFoundException e) {
			throw new GestorException(
					"[GESTOR] recuperarTodo() - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorException(
					"[GESTOR] recuperarTodo() - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.cerrarConexion(connection);
		}
		
		return personas;
	}
}
