package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Auto;
import com.desafiolatam.repositories.AutoRepository;

@Service
public class AutoService {//Clase para la lógica de negocio

	@Autowired
	AutoRepository autoRepository;
	
public Auto save(Auto auto) {
		// auto = autoRepository.save(auto);		
		return autoRepository.save(auto);
	}

	public List<Auto> findAll() {
		return autoRepository.findAll();
	}

	public void eliminarPorId(Long id) {
		autoRepository.deleteById(id);
		
	}

	public Auto findById(Long id) {
		return autoRepository.findById(id).get(); //solo con findById permite usar el método .get()
	}
	
	
	
}
