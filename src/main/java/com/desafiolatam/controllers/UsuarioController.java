package com.desafiolatam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.desafiolatam.models.Direccion;
import com.desafiolatam.models.Usuario;
import com.desafiolatam.services.DireccionService;
import com.desafiolatam.services.UsuarioService;

//El controller no me responde con un mensaje en la página como el RestController
@Controller
public class UsuarioController {

	//Inyección de dependencia
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	DireccionService direccionService;
	
	@RequestMapping("/") // https://localhost:9080
	public String showLogin() {
		return "login.jsp"; // Llamado al jsp u otra ruta
	}

	/*
	 * ruta - método - capturar - validar - OK msdOK o NOK msgError jsp
	 */

	// capturar los datos del jsp
	@PostMapping("/")
	public String registrar(
			@RequestParam(value = "correo") String correoUsuario,
			@RequestParam(value = "password") String passwordUsuario,
			Model model, // Captura desde .jsp y trae al controlador puede capturar String, Array,
			RedirectAttributes redirectAttributes, // pasar parámetro a otra url
			HttpSession session
	) {
		// Imprimir en consola
		System.out.println("correo: " + correoUsuario + ", password: " + passwordUsuario);

		
		// validad
		if (correoUsuario != null && !correoUsuario.equals("") 
				&& passwordUsuario != null && !passwordUsuario.equals("")){
			
			boolean resultado = usuarioService.validarUsuario(correoUsuario, passwordUsuario);
			
			if(resultado) {
				//Session
				session.setAttribute("correoUsuario", correoUsuario);
				return "redirect:/bienvenida";
			}else {
				model.addAttribute("msgError", "Error de ingreso, por favor reintente");
				return "login.jsp";
			}

			// pasar parámetro a otra ruta de controller, en este caso es un mensaje, pero
			// se puede pasar lo que se quiera
			//redirectAttributes.addFlashAttribute("msgOk",
			//		"Usuario creador correctamente, ingresa estos datos acá para ingresar");
			// Redireccionamiento al login
			//return "redirect:/bienvenida"; // redirigir

		} else {
			// retornar mensaje de error y mantener en la página
			model.addAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			return "login.jsp";
		}

	}

	// muestra el jsp
	@RequestMapping("/registro")
	public String showRegistro(@ModelAttribute("usuario") Usuario usuario) { //con @ModelAttribute traspasamos el objeto desde el .jsp
	//public String showRegistro(Model,model){
		//model.addAtribute("usuario", new Usuario()); /* otra forma de pasar un objeto vacío*/
		return "registro.jsp"; // Llamado al jsp u otra ruta
	}

	// capturar los datos del jsp
	@PostMapping("/registro")
	public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, 
			Model model, RedirectAttributes redirectAttributes // pasar parámetro a otra url
	) {
		// Imprimir en consola
		//System.out.println("nombre: " + usuario.getNombre() + ", apellido: " + usuario.getApellido() + ", correo: " + usuario.getCorreo()
		//		+ ", password: " + usuario.getPassword() + ", passwordControl: " + usuario.getPasswordControl());

		// validad
		if (!result.hasErrors()) {
		
			/* Forma antigua de validar, antes de @Valid y BindingResult result
			 * if (usuario.getNombre() != null && !usuario.getNombre().equals("") 
					&& usuario.getApellido() != null && !usuario.getApellido().equals("")
					&& usuario.getCorreo() != null && !usuario.getCorreo().equals("") 
					&& usuario.getPassword() != null && !usuario.getPassword().equals("") 
					&& usuario.getPasswordControl() != null && !usuario.getPasswordControl().equals(""))*/
			
			// persistencia y se pasa a un Usuario
			//Usuario usuariosCreado = usuarioService.save(usuario); --Falta tomar el método de existeUsuario y usarlo
		
			//if(usuario.getCorreo()) {
		
			Boolean usuarioCreado = usuarioService.save(usuario);
				
			if(usuarioCreado) {
				// pasar parámetro a otra ruta de controller, en este caso es un mensaje, pero
				// se puede pasar lo que se quiera
				redirectAttributes.addFlashAttribute("msgOk", "Usuario creado correctamente, ingresa estos datos acá para ingresar");
				// Redireccionamiento al login
				return "redirect:/"; // redirigir
			}else {
				// retornar mensaje de error y mantener en la página
				model.addAttribute("msgError", "Pónte en contacto con nuestro operador, error al crear usuario");
							return "registro.jsp";
			}

		} else {
			// retornar mensaje de error y mantener en la página
			model.addAttribute("msgError", "Faltan datos, por favor, reinténtalo");
			return "registro.jsp";
		}

	}

	// capturar los datos del jsp, manera antigua, dato a dato
		@PostMapping("/registro2")
		public String registrar2(@RequestParam(value = "nombre") String nombreUsuario,
				@RequestParam(value = "apellido") String apellidoUsuario,
				@RequestParam(value = "correo") String correoUsuario,
				@RequestParam(value = "password") String passwordUsuario,
				@RequestParam(value = "passwordControl") String passwordControlUsuario, Model model, // Captura desde .jsp y
																										// trae al
																										// controlador puede
																										// capturar String,
																										// Array,
				RedirectAttributes redirectAttributes // pasar parámetro a otra url
		) {
			// Imprimir en consola
			System.out.println("nombre: " + nombreUsuario + ", apellido: " + apellidoUsuario + ", correo: " + correoUsuario
					+ ", password: " + passwordUsuario + ", passwordControl: " + passwordControlUsuario);

			// validad
			if (nombreUsuario != null && !nombreUsuario.equals("") && apellidoUsuario != null && !apellidoUsuario.equals("")
					&& correoUsuario != null && !correoUsuario.equals("") && passwordUsuario != null
					&& !passwordUsuario.equals("") && passwordControlUsuario != null
					&& !passwordControlUsuario.equals("")) {

				// persistencia

				// pasar parámetro a otra ruta de controller, en este caso es un mensaje, pero
				// se puede pasar lo que se quiera
				redirectAttributes.addFlashAttribute("msgOk",
						"Usuario creador correctamente, ingresa estos datos acá para ingresar");
				// Redireccionamiento al login
				return "redirect:/"; // redirigir

			} else {
				// retornar mensaje de error y mantener en la página
				model.addAttribute("msgError", "Faltan datos, por favor, reinténtalo");
				return "registro.jsp";
			}

		}
	
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();//matar la sesión
			return "redirect:/";
		}
		
		@RequestMapping("/listaUsuariosDireccion") // https://localhost:9080/listaUsuariosDireccion
		public String mostrarListaUsuariosDireccion(@ModelAttribute("usuario") Usuario usuario, Model model) {
			model.addAttribute("listaUsuarios", usuarioService.findAll());
			return "listaUsuariosDireccion.jsp"; // Llamado al jsp u otra ruta
		}
	
		@RequestMapping("/listaDireccionesUsuarios") // https://localhost:9080/listaDireccionesUsuarios
		public String mostrarListaDireccionUsuarios(@ModelAttribute("direccion") Direccion direccion, Model model) {
			model.addAttribute("listaDirecciones", direccionService.findAll());
			return "listaDireccionesUsuarios.jsp"; // Llamado al jsp u otra ruta
		}

}
