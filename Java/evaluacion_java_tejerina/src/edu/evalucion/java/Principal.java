package edu.evalucion.java;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Random;

import edu.evalucion.java.dao.GestorDePedidos;
import edu.evalucion.java.objects.ItemPedido;
import edu.evalucion.java.objects.Pedido;

public class Principal {
	
	private static String estado1 = "Pendiente";
	private static String estado2 = "Procesado";
	private static String estado3 = "Entregado";

	public static void main(String[] args) {
		
		GestorDePedidos gestorDePedidos = new GestorDePedidos();
		
		Pedido pedido1 = new Pedido(estado(), new Date(new java.util.Date().getTime()));
		
		pedido1.setItem(gestorDePedidos.|);
		
		Pedido pedido2 = new Pedido(estado(), new Date(new java.util.Date().getTime()));
		
		
		Pedido pedido3 = new Pedido(estado(), new Date(new java.util.Date().getTime()));
		
		

	}
	
	public static String estado() {
        Random r = new Random();

        int i = r.nextInt()%3;

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
	
	public static Integer producto() {
        Random r = new Random();
        
        return r.nextInt()%20 + 1;
    }

}
