package com.desafiolatam.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

	@RequestMapping("/hi") //Get, post, put, delette
	public String hola() {
		return "Hola chiquillos"; //o mensaje o jsp u otra ruta (Controlador)
	}
	
	@RequestMapping("/hola")
	public String saludo() {
		return "Hola chiquillos parte 2"; //o mensaje o jsp u otra ruta (Controlador)
	}
	
	@RequestMapping("/isabel/delacuadra")
	public String usuario() {
		return "Hola usuario"; //o mensaje o jsp u otra ruta (Controlador)
	}
	
	@RequestMapping("/modulo/{moduloID}/seccion/{seccionID}")
	public String rutaDinamica() {
		return "Esto es una ruta dinámica"; 
	}
	
	@RequestMapping("/anio/{anio}/mes/{mes}/dia/{dia}")
	public String obteberFecha(@PathVariable("anio")int anio,
			@PathVariable("mes")String mes, //yo defino para poder sacar el 03 y que sea un String 03 y no un int 3
			@PathVariable("dia")int dia) {
		return "La fecha de hoy es: " + anio + "/" + mes + "/" + dia; 
	}
	
	//Path: http://localhost:9080/parametro?idProducto=100
	@RequestMapping("/parametro") //espera el valor del parámetro
	public String parametro(@RequestParam(value="idProducto",required=false)String id) { //Required=false significa que el parámetro puede no venir
		
		if(id == null) {
			return "no existe el parámetro";
		}else {
			return "Hola " + id;
		}
	
	}
	
}
