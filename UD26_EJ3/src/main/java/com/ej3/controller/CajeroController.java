package com.ej3.controller;

import java.util.List;
import com.ej3.dto.Cajero;
import com.ej3.service.CajeroServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl CajeroServiceImpl;
	
	//listar todos los Cajeros
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		return CajeroServiceImpl.listarCajeros();
	}
	
	//guardar un cajero
	@PostMapping("/cajeros")
	public Cajero guardarCajero(@RequestBody Cajero Cajero) {
		return CajeroServiceImpl.guardarCajero(Cajero);
	}
	
	//mostrar cajero ID
	@GetMapping("/cajeros/{id}") 
	public Cajero CajeroXID(@PathVariable(name="id") Long id){ 
		Cajero cajeroID = new Cajero();
		
		cajeroID=CajeroServiceImpl.cajeroXID(id);
		
		return cajeroID;
	}
	
	//Actualizar cajero ID
	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name="id")Long id,@RequestBody Cajero cajero) {
		
		Cajero cajero_select= new Cajero();
		Cajero cajero_update= new Cajero();
		
		cajero_select= CajeroServiceImpl.cajeroXID(id);
		
		cajero_select.setNomApels(cajero.getNomApels());
		cajero_select.setVentas(cajero.getVentas());
		
		cajero_update = CajeroServiceImpl.actualizarCajero(cajero_select);
		
		return cajero_update;
	}
	
	//eliminar cajero ID
	@DeleteMapping("/cajeros/{id}")
	public void eliminarCajero(@PathVariable(name="id")Long id) {
		CajeroServiceImpl.eliminarCajero(id);
	}
}
