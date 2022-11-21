package com.ej3.service;

import java.util.List;

import com.ej3.dto.Producto;

public interface IProductoService {

	//Métodos del CRUD
	public List<Producto> listarProductos(); //Listar All
	
	public Producto guardarProducto(Producto producto); //CREATE
	
	public Producto productoXID(Long id); //READ
	
	public Producto actualizarProducto(Producto producto); //UPDATE
	
	public void eliminarProducto(Long id);//DELETE
}
