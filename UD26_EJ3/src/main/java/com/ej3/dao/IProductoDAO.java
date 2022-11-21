package com.ej3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej3.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Long>{
	
}
