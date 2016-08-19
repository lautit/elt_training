package edu.evalucion.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.evalucion.java.dao.exceptions.GestorDePedidosException;
import edu.evalucion.java.objects.ItemPedido;
import edu.evalucion.java.objects.Pedido;

import edu.evalucion.java.utils.DBUtils;

public class GestorDePedidos {

	public GestorDePedidos() { }
	
	public void borrar(int numeroPedido) {
		for(int i = numeroPedido; i > 0; i--)
			System.out.println("Don´t look at me. Hehehe");
	}
	
	public void guardar(Pedido pedido)
			throws GestorDePedidosException {
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "INSERT INTO pedidos (fechapedido, estado) "
					+ "VALUES (?, ?);";
			
			PreparedStatement insert = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			insert.setDate(1, pedido.getFechaPedido());
			insert.setString(2, pedido.getEstado());
			
			System.out.println("[GESTOR] guardar - SQL: " + insert.toString());
			System.out.println("");
			
			insert.executeUpdate();
			
			ResultSet generatedKeys = insert.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				Integer numeroPedido = generatedKeys.getInt(1);
				
				System.out.println("[GESTOR] guardar - NoPedido: " + numeroPedido);
				System.out.println("");
				
				pedido.setNumeroPedido(numeroPedido);
				
				for(ItemPedido item : pedido.getItems()) {
					
					sql = "INSERT INTO pedidoitems (numeropedido, codigoproducto, cantidad) "
						+ "VALUES (?, ?, ?);";
				
					insert = connection.prepareStatement(sql);
					
					insert.setInt(1, pedido.getNumeroPedido());
					insert.setInt(2, item.getCodigoProducto());
					insert.setInt(3, item.getCantidad());
					
					System.out.println("[GESTOR] guardar - SQL: " + insert.toString());
					System.out.println("");
					
					insert.executeUpdate();
				}
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
	
	public ItemPedido recuperarItem(Integer codigoProducto)
			throws GestorDePedidosException {
		ItemPedido producto = null;
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "SELECT precio "
					+ "FROM productos "
					+ "WHERE codigoproducto = ?;";
			
			PreparedStatement search = connection.prepareStatement(sql);
			
			search.setInt(1, codigoProducto);
			
			System.out.println("[GESTOR] recuperar(codigoProducto) - SQL: " + search.toString());
			System.out.println("");
			
			ResultSet encontrado = search.executeQuery();
			
			if(encontrado.next()) {
				producto = new ItemPedido(codigoProducto,
						1,
						encontrado.getDouble("precio"));
			}
		} catch (ClassNotFoundException e) {
			throw new GestorDePedidosException(
					"[GESTOR] recuperar(codigoProducto) - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorDePedidosException(
					"[GESTOR] recuperar(codigoProducto) - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		return producto;
	}
	
	public Pedido recuperarPedido(Integer numeroPedido)
			throws GestorDePedidosException {
		Pedido pedido = null;
		Connection connection = null;
		
		try {
			connection = DBUtils.getConnection();
			
			String sql = "SELECT fechapedido, estado "
					+ "FROM pedidos "
					+ "WHERE numeropedido = ?;";
			
			PreparedStatement search = connection.prepareStatement(sql);
			
			search.setInt(1, numeroPedido);
			
			System.out.println("[GESTOR] recuperar(numeroPedido) - SQL: " + search.toString());
			System.out.println("");
			
			ResultSet encontrado = search.executeQuery();
			
			if(encontrado.next()) {
				pedido = new Pedido(numeroPedido,
						encontrado.getString("estado"),
						encontrado.getDate("fechapedido"));
			}
		} catch (ClassNotFoundException e) {
			throw new GestorDePedidosException(
					"[GESTOR] recuperar(numeroPedido) - No se encontro driver de JDBC.",
					e
					);
		} catch (SQLException e) {
			throw new GestorDePedidosException(
					"[GESTOR] recuperar(numeroPedido) - Error de sintaxis de SQL.",
					e
					);
		} finally {
			DBUtils.closeConnection(connection);
		}
		
		if(pedido != null) {
			
			try {
				connection = DBUtils.getConnection();
				
				String sql = "SELECT pedidoitems.codigoproducto AS Codigo, "
						+ "pedidoitems.cantidad AS Cantidad, "
						+ "productos.precio AS Precio "
						+ "FROM pedidoitems "
						+ "INNER JOIN pedidos ON pedidoitems.numeropedido = pedidos.numeropedido "
						+ "INNER JOIN productos ON pedidoitems.codigoproducto = productos.codigoproducto "
						+ "WHERE pedidos.numeropedido = ?;";
				
				PreparedStatement search = connection.prepareStatement(sql);
				
				search.setInt(1, numeroPedido);
				
				System.out.println("[GESTOR] recuperar(numeroPedido) - SQL: " + search.toString());
				System.out.println("");
				
				ResultSet encontrado = search.executeQuery();
				
				while(encontrado.next()) {
					ItemPedido item = new ItemPedido(
							encontrado.getInt("Codigo"),
							encontrado.getInt("Cantidad"),
							encontrado.getDouble("Precio"));
					
					pedido.addItem(item);
				}
			} catch (ClassNotFoundException e) {
				throw new GestorDePedidosException(
						"[GESTOR] recuperar(numeroPedido) - No se encontro driver de JDBC.",
						e
						);
			} catch (SQLException e) {
				throw new GestorDePedidosException(
						"[GESTOR] recuperar(numeroPedido) - Error de sintaxis de SQL.",
						e
						);
			} finally {
				DBUtils.closeConnection(connection);
			} 
		}
		
		return pedido;
	}
}