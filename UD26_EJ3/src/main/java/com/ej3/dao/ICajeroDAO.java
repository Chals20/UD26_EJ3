package com.ej3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej3.dto.Cajero;

public interface ICajeroDAO extends JpaRepository<Cajero, Long>{
	
}
