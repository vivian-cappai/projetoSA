package com.rocket.osworks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.osworks.domain.model.Usuario;
import com.rocket.osworks.domain.model.UsuarioRepositorio;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	private static final String USUARIO_PATH = "/Usuarios/cadastroUsuario";
	
	
	@GetMapping("/usuarios")
	public String showFormCadastro(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return USUARIO_PATH;
	}
	
	@RequestMapping(value="/usuarios")
	public String salvar(final Usuario usuario, final BindingResult bindingResult, final ModelMap model) {
	    if (bindingResult.hasErrors()) {
	        return USUARIO_PATH;
	    }
	    
	    usuarioRepositorio.save(usuario);
	    model.clear();
	    return String.format("redirect:%s", "usuarios");
	}
}
