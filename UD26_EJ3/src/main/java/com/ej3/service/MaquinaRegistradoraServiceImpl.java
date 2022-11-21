package com.ej3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej3.dao.IMaquinaRegistradoraDAO;
import com.ej3.dto.MaquinaRegistradora;

@Service 
public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraService{

	@Autowired
	IMaquinaRegistradoraDAO mRegisDAO;
	
	@Override
	public List<MaquinaRegistradora> listarMaquinaRegistradoras() {
		// TODO Auto-generated method stub
		return mRegisDAO.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora mRegistradora) {
		// TODO Auto-generated method stub
			return mRegisDAO.save(mRegistradora); 	
	}

	@Override
	public MaquinaRegistradora maquinaRegistradoraXID(Long id) {
		// TODO Auto-generated method stub
		return mRegisDAO.findById(id).get();
	}

	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora mRegistradora) {
		// TODO Auto-generated method stub
		return mRegisDAO.save(mRegistradora);
	}

	@Override
	public void eliminarMaquinaRegistradora(Long id) {
		mRegisDAO.deleteById(id);
		
	}
}
