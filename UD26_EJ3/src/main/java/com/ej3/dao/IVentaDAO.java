package com.ej3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej3.dto.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Long>{
	
}
