package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiolatam.models.Usuario; 

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ 
//Puedo cambiar la extends de CrudRepository a JpaRepository, 
//solo tengo que comentar la línea de abajo, porque no la vamos a ocupar
//No es necesario cambiar los métodos en los Service, 
// porque el nieto JpaRepository hereda los métodos
	
	Usuario findByCorreo(String correo);
}
