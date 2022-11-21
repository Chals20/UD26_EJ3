package com.ej3.controller;

import java.util.List;
import com.ej3.dto.Venta;
import com.ej3.service.VentaServiceImpl;

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
public class VentaController {

	@Autowired
	VentaServiceImpl ventaService;
	
	//listar todas ventas
	@GetMapping("/ventas")
	public List<Venta> listarVentas(){
		return ventaService.listarVentas();
	}
	
	//guardar una venta
	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta venta) {
		return ventaService.guardarVenta(venta);
	}
	
	//mostrar venta ID
	@GetMapping("/ventas/{id}") 
	public Venta VentaXID(@PathVariable(name="id") Long id){ 
		Venta ventaID = new Venta();
		
		ventaID=ventaService.ventaXID(id);

		return ventaID;
	}
	
	//actualizar venta ID
	@PutMapping("/ventas/{id}")
	public Venta actualizarVenta(@PathVariable(name="id")Long id,@RequestBody Venta venta) {
		
		Venta venta_select= new Venta();
		Venta venta_update= new Venta();
		
		venta_select= ventaService.ventaXID(id);
		
		venta_select.setCajero(venta.getCajero());
		venta_select.setMaquina(venta.getMaquina());
		venta_select.setProducto(venta.getProducto());
		
		venta_update = ventaService.actualizarVenta(venta_select);
		
		return venta_update;
	}
	
	//eliminar venta ID
	@DeleteMapping("/ventas/{id}")
	public void eliminarVenta(@PathVariable(name="id")Long id) {
		ventaService.eliminarVenta(id);
	}
}
