package com.ej3.controller;

import java.util.List;
import com.ej3.dto.Producto;
import com.ej3.service.ProductoServiceImpl;

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
public class ProductoController {

	@Autowired
	ProductoServiceImpl prodService;
	
	//listar todos los productos
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return prodService.listarProductos();
	}
	
	//guardar un producto
	@PostMapping("/productos")
	public Producto guardarProducto(@RequestBody Producto Producto) {
		return prodService.guardarProducto(Producto);
	}
	
	//mostrar prod ID
	@GetMapping("/productos/{id}") 
	public Producto ProductoXID(@PathVariable(name="id") Long id){ // 
		Producto prodID = new Producto();

		prodID=prodService.productoXID(id);
		
		return prodID;
	}
	
	//actualizar prod ID
	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name="id")Long id,@RequestBody Producto producto) {
		
		Producto prod_select= new Producto();
		Producto prod_update= new Producto();
		
		prod_select= prodService.productoXID(id);
		
		prod_select.setNombre(producto.getNombre());
		prod_select.setPrecio(producto.getPrecio());
		prod_select.setVentas(producto.getVentas());
		
		prod_update = prodService.actualizarProducto(prod_select);

		return prod_update;
	}
	
	//eliminar Producto ID
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable(name="id")Long id) {
		prodService.eliminarProducto(id);
	}
}
