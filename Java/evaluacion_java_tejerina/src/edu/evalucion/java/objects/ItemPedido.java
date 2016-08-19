package edu.evalucion.java.objects;

public class ItemPedido {

	private Integer codigoProducto;	
	private Integer cantidad;
	private Double precio;
	
	public ItemPedido(Integer codigoProducto, Integer cantidad, Double precioUnidad) {
		setCodigoProducto(codigoProducto);
		setCantidad(cantidad);
		setPrecioUnidad(precioUnidad);
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto (Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioUnidad() {
		return precio;
	}

	public void setPrecioUnidad(Double precioUnidad) {
		this.precio = precioUnidad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Articulo ");
		builder.append(codigoProducto);
		builder.append(" - Cantidad: ");
		builder.append(cantidad);
		builder.append(" - Precio: ");
		builder.append(precio);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProducto == null) ? 0 : codigoProducto.hashCode());
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
		ItemPedido other = (ItemPedido) obj;
		/*
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		*/
		if (codigoProducto == null) {
			if (other.codigoProducto != null)
				return false;
		} else if (!codigoProducto.equals(other.codigoProducto))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

}
