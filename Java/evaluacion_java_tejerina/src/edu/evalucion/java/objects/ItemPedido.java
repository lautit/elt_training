package edu.evalucion.java.objects;

public class ItemPedido {

	private Integer codigoProducto;	
	private Integer cantidad;
	private Double precio;
	
	public ItemPedido(Integer idArticulo, Integer cantidad, Double precioUnidad) {
		setIdArticulo(idArticulo);
		setCantidad(cantidad);
		setPrecioUnidad(precioUnidad);
	}

	public Integer getIdArticulo() {
		return codigoProducto;
	}

	public void setIdArticulo(Integer idArticulo) {
		this.codigoProducto = idArticulo;
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
		builder.append(" - PrecioUn:");
		builder.append(precio);
		return builder.toString();
	}

}
