package Proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import Proyecto.Repository.*;
import Proyecto.Model.Usuario;


@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioRepository repou;
	
	@GetMapping("/login/cargar")
	public String abrirLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/login/validar")
	public String validarLogin(@ModelAttribute Usuario usuario, Model model) {
		List<Usuario> listaUsuarios = repou.findAll();
		System.out.println("Enviado :" + usuario); // del formulario de login
		
		Usuario u = repou.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		
		System.out.println(u); // de la busqueda
		
		if (u == null) {
			model.addAttribute("mensaje","Usuario o clave incorrecto");
			return "login";
		}
		
		
		model.addAttribute("usuario",u);
		model.addAttribute("listaUsuarios", listaUsuarios);
		
		return "PaginaWebNueva.html";

	}
	
	@GetMapping("/usuarios/cargar")
	public String abrirRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@PostMapping("/usuarios/grabar")
	public String grabarRegistro(@ModelAttribute Usuario usuario, Model model) {
		
		System.out.println("Enviado :" + usuario);
		
		try {
			repou.save(usuario);
			model.addAttribute("sucess","Usuario registrado");
			
		} catch (Exception e) {
			model.addAttribute("error","Error al registrar");
		}
		
		
		return "register";
	}
	
	@GetMapping("/usuario/lista")
	public String ListaUsuario(Model model) {
		model.addAttribute("listaUsuarios", repou.findAll());
		return "listado";
	}
	
	
	
	
	
	@GetMapping("/principal")
	public String abrirLogin() {
		return "principal";
	}
}
