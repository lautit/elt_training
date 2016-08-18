package edu.evalucion.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import edu.evalucion.java.dao.exceptions.GestorDePedidosException;
import edu.evalucion.java.objects.ItemPedido;
import edu.evalucion.java.objects.Pedido;

import edu.evalucion.java.utils.DBUtils;

public class GestorDePedidos {

	public GestorDePedidos() { }
	
	public void borrar(int numeroPedido) {
		
	}
	
	public void guardar(Pedido pedido)
			throws GestorDePedidosException {
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "INSERT INTO evaluacion_java_tejerina.pedidos "
					+ "(fechapedido, estado) "
					+ "VALUES (?, ?);";
			
			PreparedStatement insert = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			insert.setDate(1, pedido.getFechaPedido());
			insert.setString(2, pedido.getEstado());
			
			insert.executeUpdate();
			
			System.out.println("[GESTOR] guardar - SQL: " + insert.toString());
			
			ResultSet generatedKeys = insert.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				Integer numeroPedido = generatedKeys.getInt(1);
				
				System.out.println("[GESTOR] guardar - ID: " + numeroPedido);
				
				pedido.setNumeroPedido(numeroPedido);
			}			
		} catch (ClassNotFoundException e) {
			throw new GestorDePedidosException(
					"[GESTOR] guardar(Pedido) - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorDePedidosException(
					"[GESTOR] guardar(Pedido) - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.closeConnection(connection);
		}
	}
	/*
	public LinkedList<Pedido> listar() {
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "SELECT pedidos.numeropedido,"
					+ "pedidos.fechapedido,"
					+ "pedidos.estado "
					+ "FROM evaluacion_java_tejerina.pedidos;";
			
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
				
				pedidos.add(persona);
				
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
			DBUtils.closeConnection(connection);
		}
		
		return pedidos;
	}
	
	public Pedido recuperar(int numeroPedido) {
		Pedido pedido = null;
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "SELECT nombre, apellido, edad "
					+ "FROM personas "
					+ "WHERE idpersona = ?;";
			
			PreparedStatement search = connection.prepareStatement(sql);
			
			search.setInt(1, idPersona);
			
			System.out.println("[GESTOR] buscarPorID - SQL: " + search.toString());
			
			ResultSet encontrado = search.executeQuery();
			
			if(encontrado.next()) {
				pedido = new Persona(idPersona,
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
			DBUtils.closeConnection(connection);
		}
		
		return pedido;
	}
	
	public ItemPedido recuperar(Integer numeroPedido, Integer idArticulo) {
		ItemPedido itemPedido = null;
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "SELECT nombre, apellido, edad "
					+ "FROM personas "
					+ "WHERE idpersona = ?;";
			
			PreparedStatement search = connection.prepareStatement(sql);
			
			search.setInt(1, idPersona);
			
			System.out.println("[GESTOR] buscarPorID - SQL: " + search.toString());
			
			ResultSet encontrado = search.executeQuery();
			
			if(encontrado.next()) {
				itemPedido = new Persona(idPersona,
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
		
		return itemPedido;
	}
	*/
	
	public ItemPedido recuperar(Integer idArticulo) {
		ItemPedido producto = null;
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "SELECT productos.codigoproducto, productos.precio "
					+ "FROM evaluacion_java_tejerina.productos "
					+ "WHERE codigoproducto = ?;";
			
			"select productos.codigoproducto as Producto,"
			+ "orderdetails.quantityOrdered								as Quantity,"
			+ "orderdetails.priceEach										as UnitPrice,"
			+ "(orderdetails.quantityOrdered * orderdetails.priceEach)		as Subtotal"
			+ "from		orderdetails"
			+ "inner join	products"
			+ "on			orderdetails.productCode = products.productCode"
			+ "where		orderdetails.orderNumber = 10175"
			+ "group by	Product"
			+ "order by	orderdetails.orderLineNumber								asc;";
			
			PreparedStatement search = connection.prepareStatement(sql);
			
			search.setInt(1, idArticulo);
			
			System.out.println("[GESTOR] buscarPorID - SQL: " + search.toString());
			
			ResultSet encontrado = search.executeQuery();
			
			if(encontrado.next()) {
				producto = new ItemPedido(idArticulo,);
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
		
		return producto;
	}
}
