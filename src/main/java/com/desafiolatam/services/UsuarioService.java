package com.desafiolatam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.UsuarioRepository;

@Service
public class UsuarioService { //Clase para la lógica de negocio

	@Autowired
	UsuarioRepository usuarioRepository;

	public Boolean save(Usuario usuario) {
		//Validar que existe o no el usuario, para que no se repita
		Usuario existeUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
		//Si el usuario es igual a null, créalo 
		if(existeUsuario == null) {
			//usuario = usuarioRepository.save(usuario);
			usuarioRepository.save(usuario);
			return true;
		//sino, retorna usuario existe
		}else {
			return false;
		}
		
	}

	public boolean validarUsuario(String correoUsuario, String passwordUsuario) {
		
		Usuario usuario = usuarioRepository.findByCorreo(correoUsuario);
		if(usuario != null) { //si es distinto de null existe un usuario con ese correo 
			if(passwordUsuario.equals(usuario.getPassword())) {
				return true;
			}else {
				return false; //Password distintas
			}
			
		}else { //False por que no existe para ese correo 
			return false;
		}
		
	}

	public Usuario findByCorreo(String correoUsuario) {
		return usuarioRepository.findByCorreo(correoUsuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
}
