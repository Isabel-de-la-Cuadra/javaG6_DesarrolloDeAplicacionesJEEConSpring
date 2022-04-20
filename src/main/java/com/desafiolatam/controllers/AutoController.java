package com.desafiolatam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Auto;
import com.desafiolatam.models.Usuario;
import com.desafiolatam.services.AutoService;
import com.desafiolatam.services.UsuarioService;

@Controller
@RequestMapping("/auto")
public class AutoController {

	// Inyección de dependencia
	@Autowired
	AutoService autoService;

	@Autowired
	UsuarioService usuarioService;

	// muestra el jsp
	@RequestMapping("") // https://localhost:9080/auto
	public String showAuto(@ModelAttribute("auto") Auto auto, Model model, HttpSession session) { 
		// con @ModelAttribute traspasamos el objeto desde el .jsp
		
		// public String showRegistro(Model,model){
		// model.addAtribute("usuario", new Usuario()); 
		// otra forma de pasar un objeto vacío

		// Lista Autos porque lo vamos a desplegar al final del formulario
		// Ir a buscar a la base de datos: autoService.findAll();
		// listaAutos
		
		if (session.getAttribute("correoUsuario") != null) {
			String correoUsuario = (String) session.getAttribute("correoUsuario");

			Usuario usuario = usuarioService.findByCorreo(correoUsuario);
			model.addAttribute("nombreUsuario", usuario.getNombre());

			model.addAttribute("listaAutos", autoService.findAll());

			return "auto/auto.jsp"; // Llamado al jsp u otra ruta
		} else {
			return "redirect:/";
		}
	}

	// capturar los datos del jsp
	@PostMapping("")
	public String registrar(@Valid @ModelAttribute("auto") Auto auto, BindingResult result, Model model,
			RedirectAttributes redirectAttributes // pasar parámetro a otra url o al .jsp
	) {
		// Imprimir en consola
		System.out.println("marca: " + auto.getMarca() + ", modelo: " + auto.getModelo() + ", color: " + auto.getColor()
				+ ", velocidad: " + auto.getVelocidad());

		// validad
		if (!result.hasErrors()) {
			// persistencia cuando no hay error y creo de inmediato una instancia de Auto
			// Auto autoCreado = autoService.save(auto);
			// Persistencia cuando no hay error
			autoService.save(auto);

			// pasar parámetro a otra ruta de controller, en este caso es un mensaje, pero
			// se puede pasar lo que se quiera
			redirectAttributes.addFlashAttribute("msgOk", "Auto creado correctamente");

		} else {
			model.addAttribute("listaAutos", autoService.findAll());
			// retornar mensaje de error y mantener en la página
			redirectAttributes.addFlashAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			return "auto/auto.jsp"; // redirigir
		}
		// Redireccionamiento al mismo /auto, pero con mensajes diferentes
		return "redirect:/auto"; // redirigir
	}

	// método eliminar con captura dinámina
	// auto/eliminar/${auto.id}
	@RequestMapping("/eliminar/{autoId}")
	public String eliminarAuto(@PathVariable("autoId") Long id, RedirectAttributes redirectAttributes) {
		autoService.eliminarPorId(id);
		redirectAttributes.addFlashAttribute("msgOk", "Auto eliminado correctamente");
		return "redirect:/auto";
	}

	// método editar
	// auto/editar/${auto.id}
	@RequestMapping("/editar/{id}")
	public String editarAuto(@PathVariable("id") Long id, Model model) {
		Auto auto = autoService.findById(id);
		model.addAttribute("auto", auto);
		// TB model.addAttribute("auto", autoServive.findById(id);

		return "auto/editarAuto.jsp";
	}

	// capturar los datos del jsp después de modificar
	@PostMapping("/actualizar")
	public String actualizarAuto(@Valid @ModelAttribute("auto") Auto auto, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("Auto actualizado " + auto.getId());

		if (!result.hasErrors()) {
			autoService.save(auto);
			redirectAttributes.addFlashAttribute("msgOk", "Auto actualizado correctamente");
			return "redirect:/auto";
		} else {
			model.addAttribute("listaAutos", autoService.findAll());
			// retornar mensaje de error y mantener en la página
			redirectAttributes.addFlashAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			return "auto/auto.jsp"; // redirigir
		}
	}

}