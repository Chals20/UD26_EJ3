package com.ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej3.dao.ICajeroDAO;
import com.ej3.dto.Cajero;

@Service 
public class CajeroServiceImpl implements ICajeroService{

	@Autowired
	ICajeroDAO cajeroDAO;
	
	@Override
	public List<Cajero> listarCajeros() {
		// TODO Auto-generated method stub
		return cajeroDAO.findAll();
	}

	@Override
	public Cajero guardarCajero(Cajero cajero) {
		// TODO Auto-generated method stub
			return cajeroDAO.save(cajero); 	
	}

	@Override
	public Cajero cajeroXID(Long id) {
		// TODO Auto-generated method stub
		return cajeroDAO.findById(id).get();
	}

	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		// TODO Auto-generated method stub
		return cajeroDAO.save(cajero);
	}

	@Override
	public void eliminarCajero(Long id) {
		cajeroDAO.deleteById(id);
		
	}
}
