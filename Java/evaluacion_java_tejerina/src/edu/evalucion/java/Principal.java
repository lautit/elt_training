package edu.evalucion.java;

import edu.evalucion.java.dao.GestorDePedidos;
import edu.evalucion.java.dao.exceptions.GestorDePedidosException;
import edu.evalucion.java.objects.Pedido;
import edu.evalucion.java.utils.PedidoUtils;

public class Principal {

	public static void main(String[] args) {
		GestorDePedidos gestorDePedidos = new GestorDePedidos();
		PedidoUtils pedidoUtils = new PedidoUtils(gestorDePedidos);
		
		Pedido pedido1 = pedidoUtils.popular();
		
		System.out.println("vamos a guardar un pedido");
		
		try {
			gestorDePedidos.guardar(pedido1);
			System.out.println("guarde el pedido 1");
		} catch (GestorDePedidosException e) {
			e.printStackTrace();
		}
		
		System.out.println("ahora lo volvemos a recuperar");
		
		Pedido pedido2 = null;
		
		try {
			pedido2 = gestorDePedidos.recuperarPedido(pedido1.getNumeroPedido());	
		} catch (GestorDePedidosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("recupere el pedido 1? a ver");
		
		if(pedido2 != null)
			System.out.println("segun el equals() sobrecargado, pedido 1 es "
					+ (pedido2.equals(pedido1) ? "igual" : "distinto")
					+ " al pedido 2");
		else
			System.out.println("no me recupero nada!");
		
		System.out.println("esto es todo amigos");
		
		//Pedido pedido2 = pedidoUtils.popular();
		
		//Pedido pedido3 = pedidoUtils.popular();

	}

}
