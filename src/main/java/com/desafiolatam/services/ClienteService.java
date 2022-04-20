package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.repositories.ClienteRepository;

@Service
public class ClienteService {// Clase para la lógica de negocio

	@Autowired
	ClienteRepository clienteRepository;

	public Cliente save(Cliente cliente) {

		// cliente = clienteRepository.save(cliente);

		return clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public void eliminarPorId(Long id) {
		clienteRepository.deleteById(id);

	}

	public Cliente findById(Long id) {
		return clienteRepository.findById(id).get(); // solo con findById permite usar el método .get()
	}

	public Cliente obtenerCliente(Long id) {
		return clienteRepository.findById(id).get();
	}
}
