package com.ej3.controller;

import java.util.List;
import com.ej3.dto.MaquinaRegistradora;
import com.ej3.service.MaquinaRegistradoraServiceImpl;

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
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraServiceImpl mRegService;
	
	//listar todas MR
	@GetMapping("/maquinas")
	public List<MaquinaRegistradora> listarMaquinaRegistradoras(){
		return mRegService.listarMaquinaRegistradoras();
	}
	
	//guardar una MR
	@PostMapping("/maquinas")
	public MaquinaRegistradora guardarMaquinaRegistradora(@RequestBody MaquinaRegistradora mReg) {
		return mRegService.guardarMaquinaRegistradora(mReg);
	}
	
	//mostrar MR por ID
	@GetMapping("/maquinas/{id}") 
	public MaquinaRegistradora MaquinaRegistradoraXID(@PathVariable(name="id") Long id){ 
		MaquinaRegistradora mRegID = new MaquinaRegistradora();
		
		mRegID=mRegService.maquinaRegistradoraXID(id);
		
		return mRegID;
	}
	
	//actualizar MR por ID
	@PutMapping("/maquinas/{id}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="id")Long id,@RequestBody MaquinaRegistradora mReg) {
		
		MaquinaRegistradora mReg_select= new MaquinaRegistradora();
		MaquinaRegistradora mReg_update= new MaquinaRegistradora();
		
		mReg_select= mRegService.maquinaRegistradoraXID(id);
		
		mReg_select.setPiso(mReg.getPiso());
		mReg_select.setVentas(mReg.getVentas());
		
		mReg_update = mRegService.actualizarMaquinaRegistradora(mReg_select);

		return mReg_update;
	}
	
	//eliminar MR por ID
	@DeleteMapping("/maquinas/{id}")
	public void eleiminarMaquinaRegistradora(@PathVariable(name="id")Long id) {
		mRegService.eliminarMaquinaRegistradora(id);
	}
}
