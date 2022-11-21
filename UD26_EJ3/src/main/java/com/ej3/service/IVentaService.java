package com.ej3.service;

import java.util.List;

import com.ej3.dto.Venta;

public interface IVentaService {

	//Métodos del CRUD
	public List<Venta> listarVentas(); //Listar All
	
	public Venta guardarVenta(Venta venta); //CREATE
	
	public Venta ventaXID(Long id); //READ
	
	public Venta actualizarVenta(Venta venta); //UPDATE
	
	public void eliminarVenta(Long id);//DELETE
}
