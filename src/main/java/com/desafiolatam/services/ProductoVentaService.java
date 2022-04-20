package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.ProductosVentas;
import com.desafiolatam.repositories.ProductoVentaRepository;

@Service
public class ProductoVentaService {
	@Autowired
	ProductoVentaRepository productoVentaRepository;

	public void save(ProductosVentas productosVentas) {
		productoVentaRepository.saveAndFlush(productosVentas);
		
	}

	public List<ProductosVentas> findAll() {
		return productoVentaRepository.findAll();
		
	}

	public List<ProductosVentas> findAllByVentaId(Long id) {
		return productoVentaRepository.findAllProductosVentasWhereVentaId(id);
	}
	
	public List<ProductosVentas> findAllProductosVentas(Long id) {
		return productoVentaRepository.findAllProductosVentas(id);
	}
	
}
