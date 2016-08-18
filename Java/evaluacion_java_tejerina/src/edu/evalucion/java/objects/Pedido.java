package edu.evalucion.java.objects;

import java.sql.Date;
import java.util.LinkedList;

public class Pedido {

	private Integer numeroPedido;
	private String estado;
	private Date fechaPedido;
	private LinkedList<ItemPedido> items;
	
	public Pedido(String estado, Date fechaPedido) {
		setNumeroPedido(0);
		setEstado(estado);
		setFechaPedido(fechaPedido);
		items = new LinkedList<ItemPedido>();
	}
	
	public Pedido(Integer numeroPedido, String estado, Date fechaPedido) {
		setNumeroPedido(numeroPedido);
		setEstado(estado);
		setFechaPedido(fechaPedido);
		items = new LinkedList<ItemPedido>();
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LinkedList<ItemPedido> getItems() {
		return items;
	}

	public void setItem(ItemPedido item) {
		items.add(item);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido N°");
		builder.append(numeroPedido);
		builder.append(" Estado: ");
		builder.append(estado);
		builder.append(" Fecha: ");
		builder.append(fechaPedido);
		builder.append(System.getProperty("line.separator"));
		builder.append("Detalle de pedido:");
		for(ItemPedido item : items) {
			builder.append(System.getProperty("line.separator"));
			builder.append(item.toString());
		}
		return builder.toString();
	}
	
}
