package edu.curso.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ProductoDAO;
import edu.curso.java.spring.service.ProductoService;


public class Principal0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext appContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Producto producto = new Producto();
		producto.setNombre("tubiega");
		double precio = 1000;
		producto.setPrecio(precio);
		
//		ProductoDAO productoDAO = (ProductoDAO) appContext.getBean("productoDAOImp");
//		productoDAO.guardarProducto(producto);
		
		ProductoService productoSvc = (ProductoService) appContext.getBean(ProductoService.class);
		try {
			productoSvc.crearNuevoProductoSimple(producto);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
