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

import com.desafiolatam.models.Cliente;
import com.desafiolatam.models.Usuario;
import com.desafiolatam.services.ClienteService;
import com.desafiolatam.services.UsuarioService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	// Inyección de dependencia
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	UsuarioService usuarioService;

	// muestra el jsp
	@RequestMapping("") // https://localhost:9080/cliente
	public String showRegistro(@ModelAttribute("cliente") Cliente cliente, Model model, HttpSession session) { 
		// con @ModelAttributte traspasamos el objeto desde el .jsp
		// public String showRegistro(Model,model){
		// model.addAtribute("cliente", new Cliente()); /* otra forma de pasar un objeto
		// vacío*/

		if (session.getAttribute("correoUsuario") != null) {
			String correoUsuario = (String) session.getAttribute("correoUsuario");
			Usuario usuario = usuarioService.findByCorreo(correoUsuario);
			model.addAttribute("nombreUsuario", usuario.getNombre());
			
			// listaClientes
			model.addAttribute("listaClientes", clienteService.findAll());
			return "cliente.jsp"; // Llamado al jsp u otra ruta
		} else {
			return "redirect:/";
		}
	}

	// capturar los datos del jsp
	@PostMapping("")
	public String registrar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		// pasar parámetro a otra url

		// validad
		if (!result.hasErrors()) {
			// persistencia
			clienteService.save(cliente);

			// pasar parámetro a otra ruta de controller, en este caso es un mensaje, pero
			// se puede pasar lo que se quiera
			redirectAttributes.addFlashAttribute("msgOk", "Cliente creado correctamente");

		} else {
			model.addAttribute("listaClientes", clienteService.findAll());
			// retornar mensaje de error y mantener en la página
			redirectAttributes.addFlashAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			// Redirigir
			return "cliente.jsp";
		}

		// Redireccionamiento al mismo /cliente, pero con mensajes diferentes
		return "redirect:/cliente"; // redirigir
	}

	// método eliminar con captura dinámina
	// cliente/eliminar/${cliente.id}
	@RequestMapping("/eliminar/{id}")
	public String eliminarCliente(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		clienteService.eliminarPorId(id);
		redirectAttributes.addFlashAttribute("msgOk", "Cliente eliminado correctamente");
		return "redirect:/cliente";
	}

	// método editar
	// cliente/editar/${cliente.id}
	@RequestMapping("/editar/{id}")
	public String editarCliente(@PathVariable("id") Long id, Model model) {
		Cliente cliente = clienteService.findById(id);
		model.addAttribute("cliente", cliente);
		// TB model.addAttribute("cliente", clienteServive.findById(id);

		return "editarCliente.jsp";
	}

	// capturar los datos del jsp después de modificar
	@PostMapping("/actualizar")
	public String actualizarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		System.out.println("Cliente actualizado " + cliente.getId());
		if (!result.hasErrors()) {
			// persistencia
			clienteService.save(cliente);

			// pasar parámetro a otra ruta de controller, en este caso es un mensaje, pero
			// se puede pasar lo que se quiera
			redirectAttributes.addFlashAttribute("msgOk", "Cliente actualizado correctamente");

		} else {
			// model.addAttribute("listaClientes", clienteService.findAll());
			// retornar mensaje de error y mantener en la página en este caso no nos sirve
			// redirectAttributes.addFlashAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			// Redirigir
			
			return "editarCliente.jsp";
		}

		// Redireccionamiento al mismo /cliente, pero con mensajes diferentes
		return "redirect:/cliente"; // redirigir
	}

}
