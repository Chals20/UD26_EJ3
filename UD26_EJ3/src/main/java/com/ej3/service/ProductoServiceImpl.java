package com.ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej3.dao.IProductoDAO;
import com.ej3.dto.Producto;

@Service 
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoDAO productDAO;
	
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
			return productDAO.save(producto); 	
	}

	@Override
	public Producto productoXID(Long id) {
		// TODO Auto-generated method stub
		return productDAO.findById(id).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productDAO.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		productDAO.deleteById(id);
		
	}
}
