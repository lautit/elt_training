package edu.curso.java.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.spring.bo.Producto;
import edu.curso.java.spring.dao.ProductoDAO;

@Service
@Transactional(rollbackFor=Exception.class)
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoDAO productoDAO;
	
	@Override
	public Long crearNuevoProductoSimple(Producto producto) throws Exception {
		if(producto.getPrecio() <= 0)
			throw new Exception("tubiega es muy barata");
		
		productoDAO.guardarProducto(producto);
		return producto.getId();
	}

}
