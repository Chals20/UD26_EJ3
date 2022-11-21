package com.ej3.service;

import java.util.List;

import com.ej3.dto.Cajero;

public interface ICajeroService {

	//Métodos del CRUD
	public List<Cajero> listarCajeros(); //Listar All
	
	public Cajero guardarCajero(Cajero cajero); //CREATE
	
	public Cajero cajeroXID(Long id); //READ
	
	public Cajero actualizarCajero(Cajero cajero); //UPDATE
	
	public void eliminarCajero(Long id);//DELETE
}
