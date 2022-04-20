package com.desafiolatam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Venta;
import com.desafiolatam.repositories.VentaRepository;

@Service
public class VentaService {

	@Autowired
	VentaRepository ventaRepository;

	public Venta save(Venta venta) {
		Venta ventaCreada = ventaRepository.saveAndFlush(venta);
		return ventaCreada;
	}

	public Venta findById(Long ventaId) {
		return ventaRepository.getById(ventaId);
	}

	public Boolean existsById(Long ventaId) {
		return ventaRepository.existsById(ventaId);
	}
}