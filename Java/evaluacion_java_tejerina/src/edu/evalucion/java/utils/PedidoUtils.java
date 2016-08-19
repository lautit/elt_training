package edu.evalucion.java.utils;

import java.sql.Date;
import java.util.Random;

import edu.evalucion.java.dao.GestorDePedidos;
import edu.evalucion.java.dao.exceptions.GestorDePedidosException;
import edu.evalucion.java.objects.ItemPedido;
import edu.evalucion.java.objects.Pedido;

public class PedidoUtils {
	
	private static final String estado1 = "Pendiente";
	private static final String estado2 = "Procesado";
	private static final String estado3 = "Entregado";
	
	private GestorDePedidos gestorDePedidos;
	
	public PedidoUtils(GestorDePedidos gestorDePedidos) {
		this.gestorDePedidos = gestorDePedidos;
	}
	
	public Pedido popular() {
		Pedido pedido = new Pedido(estado(), new Date(new java.util.Date().getTime()));
		
		try {
			for(int i = cantidad(); i > 0; i--) {
				ItemPedido item = gestorDePedidos.recuperarItem(producto());
				item.setCantidad(cantidad());
				pedido.addItem(item);
			}
		} catch (GestorDePedidosException e) {
			e.printStackTrace();
		}
		
		System.out.println("[MAIN] Populando pedido");
		System.out.println(pedido.toString());
		System.out.println("");
		
		return pedido;
	}
	
	private String estado() {
        Random r = new Random();

        int i = Math.abs(r.nextInt()%3);

        switch (i) {
            case 0:
                return estado1;
            case 1:
                return estado2;
            case 2:
                return estado3;
        }
        
		return estado1;
    }
	
	private Integer producto() {
        Random r = new Random();
        
        return Math.abs(r.nextInt()%20) + 1;
    }
	
	private Integer cantidad() {
        Random r = new Random();
        
        return Math.abs(r.nextInt()%10) + 1;
	}

}
