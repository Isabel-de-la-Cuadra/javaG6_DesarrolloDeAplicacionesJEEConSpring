package com.desafiolatam.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Cliente;
import com.desafiolatam.models.Direccion;
import com.desafiolatam.services.DireccionService;
import com.desafiolatam.services.UsuarioService;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
//un usuario, una dirección
	
	@Autowired
	DireccionService direccionService;
	
	@Autowired
	UsuarioService usuarioService;
	
	//despliegue
	@RequestMapping("/usuario") // https://localhost:9080
	public String mostrarJSPDireccion(@ModelAttribute("direccion") Direccion direccion, Model model) {
		
		model.addAttribute("listaUsuarios", usuarioService.findAll());
		
		return "direccion.jsp"; // Llamado al jsp u otra ruta
	}
	
	@PostMapping("/usuario/agregar")
	public String capturaDireccion(@Valid @ModelAttribute("direccion") Direccion direccion, 
			BindingResult result, Model model, RedirectAttributes redirectAttributes) {
		
		if(!result.hasErrors()) { //no existe error
			//Validar si selecciono o no un usuario
			direccionService.save(direccion);
			redirectAttributes.addFlashAttribute("msgOk", "Dirección creada correctamente");
			
			
			return "redirect:/direccion";
		}else {//existe error capturado por el @Valid
			model.addAttribute("listaUsuarios", usuarioService.findAll());
			return "direccion.jsp"; // Llamado al jsp u otra ruta
		}
	}
	
	
	
}