package edu.evalucion.java.objects;

import java.sql.Date;
import java.util.HashSet;

public class Pedido {

	private Integer numeroPedido;
	private String estado;
	private Date fechaPedido;
	private HashSet<ItemPedido> items;
	
	public Pedido(String estado, Date fechaPedido) {
		setNumeroPedido(0);
		setEstado(estado);
		setFechaPedido(fechaPedido);
		items = new HashSet<ItemPedido>();
	}
	
	public Pedido(Integer numeroPedido, String estado, Date fechaPedido) {
		setNumeroPedido(numeroPedido);
		setEstado(estado);
		setFechaPedido(fechaPedido);
		items = new HashSet<ItemPedido>();
	}
	
	public Double calcularTotal() {
		Double total = 0.0;
		
		for(ItemPedido item : items)
			total = item.getCantidad() * item.getPrecioUnidad();
		
		return total;
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

	public HashSet<ItemPedido> getItems() {
		return items;
	}

	public void addItem(ItemPedido item) {
		System.out.println("[PEDIDO] addItem - Pedido: " + getNumeroPedido());
		System.out.println("[PEDIDO] addItem - Item: " + item.toString());
		items.add(item);
		System.out.println("");
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
			if(item != null) {
				builder.append(System.getProperty("line.separator"));
				builder.append(item.toString());
			}
		}
		builder.append(System.getProperty("line.separator"));
		builder.append("Total: " + calcularTotal());
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroPedido == null) ? 0 : numeroPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaPedido == null) {
			if (other.fechaPedido != null)
				return false;
		} else if (!fechaPedido.equals(other.fechaPedido))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else {
			boolean itemsIguales = true;
			
			for(ItemPedido item : items) {
				if(!other.items.contains(item)) {
					itemsIguales = false;
					break;
				}
			}
			
			return itemsIguales;
		}
		if (numeroPedido == null) {
			if (other.numeroPedido != null)
				return false;
		} else if (!numeroPedido.equals(other.numeroPedido))
			return false;
		return true;
	}
	
}
