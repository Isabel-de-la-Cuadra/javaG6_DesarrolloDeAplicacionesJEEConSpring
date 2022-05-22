package com.desafiolatam.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.repositories.RolRepository;
import com.desafiolatam.repositories.UsuarioRepository;

@Service
public class UsuarioService { //Clase para la lógica de negocio

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RolRepository rolRepository;

	public boolean guardarUsuario(Usuario usuario) {
		Usuario usuarioRetorno = usuarioRepository.findByCorreo(usuario.getCorreo());
		if (usuarioRetorno == null) {
			//password encriptado
			String passHashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			//1234 -> $223tgf4vt45tvt534dsvhdj
			usuario.setPassword(passHashed);
			
			//BUSCAR ROL a DB;  ASIGNAR ROL; ROLE_ADMIN, ROLE_USER
			usuario.setRoles(rolRepository.findByNombre("ROLE_USER"));
			
			usuarioRepository.save(usuario);
			return true;
		}else {
			return false;
		}
	}
	
	/*
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
*/
	
	//Asignarle un nuevo rol a un usuario (recordar relación ManyToMany)
		public boolean agregarRol(Usuario usuario) {
			
			usuarioRepository.save(usuario);
			return true;
	}
	
		
		public boolean login(String correo, String password) {
			// buscar si existe con ese email
			Usuario usuario = usuarioRepository.findByCorreo(correo);
			
			if (usuario != null) {//si existe o no el correo
				//if (usuario.getPassword().equals(password)) {//si password son iguales
				if(BCrypt.checkpw(password, usuario.getPassword())) {
					return true;
				} else {
					return false;//pasword distintos
				}
			}else {
				return false;//no existe ese correo
			}
		}
	
/*	
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
*/
	
	/*public Usuario findByCorreo(String correoUsuario) {
		return usuarioRepository.findByCorreo(correoUsuario);
	}*/
		
		public Usuario findByEmail(String username) {
			Usuario usuario = usuarioRepository.findByCorreo(username);
			return usuario;
		}
		

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
}
