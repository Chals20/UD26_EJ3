package com.ej3.service;

import java.util.List;

import com.ej3.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	//Métodos del CRUD
	public List<MaquinaRegistradora> listarMaquinaRegistradoras(); //Listar All
	
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora); // CREATE
	
	public MaquinaRegistradora maquinaRegistradoraXID(Long id); // READ
	
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora MaquinaRegistradora); //UPDATE
	
	public void eliminarMaquinaRegistradora(Long id);//DELETE
}
