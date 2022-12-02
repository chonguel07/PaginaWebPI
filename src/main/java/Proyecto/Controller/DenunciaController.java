package Proyecto.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import Proyecto.Model.Denuncia;
import Proyecto.Repository.IDenunciaRepository;


@Controller
public class DenunciaController {

	@Autowired
	private IDenunciaRepository denu;
	
	@GetMapping("/denuncia/cargar")
	public String abrirRegistro(Model model) {
		model.addAttribute("denuncia", new Denuncia());
		return "denuncia";
	}
	
	@PostMapping("/denuncia/grabar")
	public String grabarRegistro(@ModelAttribute Denuncia denuncia, Model model) {
		
		System.out.println("Enviado :" + denuncia);
		
		try {
			denu.save(denuncia);
			model.addAttribute("sucess","Usuario registrado");
			
		} catch (Exception e) {
			model.addAttribute("error","Error al registrar");
		}
		
		
		return "denuncia";
	}
	
	@GetMapping("/denuncia/lista")
	public String ListaUsuario(Model model) {
		model.addAttribute("denuncias", denu.findAll());
		return "listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
    public String eliminar(Denuncia denuncia){
		denu.delete(denuncia);
        return "redirect:/denuncia/lista";
    
    }
	
	
	@GetMapping("/edit/{codigo}")
	public String edit(@PathVariable("codigo") int codigo,Model model) {
		Denuncia denuncia = denu.findById(codigo).get();
		model.addAttribute("denuncia",denuncia);
		return "denunciaactu";
	}
	
	@PostMapping("/actualizar/{codigo}")
	public String actualizar(@PathVariable("codigo") int codigo, Denuncia denuncia,BindingResult result, Model model) {
		if(result.hasErrors()) {
			denuncia.setCodigo(codigo);
		}
		denu.save(denuncia);
		
		model.addAttribute("denuncia",denu.findAll());
		return "redirect:/denuncia/lista";
	}
	

	
	
	@GetMapping("/a")
	public String abrirLogin() {
		return "denuncia";
	}
	
}
