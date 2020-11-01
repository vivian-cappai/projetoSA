package com.algaworks.osworks.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.model.ClienteRepositorio;
import com.algaworks.osworks.domain.model.Produto;
import com.algaworks.osworks.domain.model.ProdutoRepositorio;

@RequestMapping("/produtos")
@RestController
public class ProdutoController {
	/*Injetando dependencias*/
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	/*Salvando o produto com o id do cliente*/
	@PostMapping
	public Produto salvarProduto(@RequestBody Produto produto) {
		Long idCliente = produto.getCliente().getId();
		Cliente cliente = clienteRepositorio.findById(idCliente).get();
		produto.setCliente(cliente);
		return produtoRepositorio.save(produto);
	}
	
	/*Buscando produto por id*/
	@GetMapping("/{id}")
	public Produto buscarProduto(@PathVariable Long id) {
		return produtoRepositorio.findById(id).get();
	}
}
