package com.rocket.osworks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rocket.osworks.domain.model.Produto;
import com.rocket.osworks.domain.model.ProdutoRepositorio;
import com.rocket.osworks.domain.model.Usuario;
import com.rocket.osworks.domain.model.UsuarioRepositorio;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	private static final String PRODUTO_PATH = "/Produtos/produto";
	
	@GetMapping("/produtos")
	public String showFormProduto(Model model) {
		Produto produto = new Produto();
		model.addAttribute("produto", produto);
		return PRODUTO_PATH;
	}
	
	@RequestMapping(value="/produtos")
	public String salvar(final Produto produto, final BindingResult bindingResult, final ModelMap model) {
	    if (bindingResult.hasErrors()) {
	        return PRODUTO_PATH;
	    }
	    
	    produtoRepositorio.save(produto);
	    model.clear();
	    return String.format("redirect:%s", "produtos");
	}
	
	
	@GetMapping("/produtos/deletar/{id}")
	public String deletarProduto(@PathVariable long id, Model model) {
		model.addAttribute("produto", produtoRepositorio.findById(id));
		return "produtos/delete";
	}
}
