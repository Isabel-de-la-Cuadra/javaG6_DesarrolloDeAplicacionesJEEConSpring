package com.desafiolatam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desafiolatam.models.Usuario;
import com.desafiolatam.services.UsuarioService;

//El controller no me responde con un mensaje en la página como el RestController
@Controller
public class HomeController {

	@Autowired
	UsuarioService usuarioService;
	/*
	 * ruta método llamado .jsp bienvenida.jsp o index.jsp
	 */

	@RequestMapping("/bienvenida")
	public String bienvenida(HttpSession session, Model model) {

		if (session.getAttribute("correoUsuario") != null) {
			// Session, capturamos el atributo
			String correoUsuario = (String) session.getAttribute("correoUsuario");
			Usuario usuario = usuarioService.findByCorreo(correoUsuario);
			model.addAttribute("nombreUsuario", usuario.getNombre());
			return "bienvenida.jsp"; // Llamado al jsp u otra ruta
		} else {
			return "redirect:/";
		}

	}
}
