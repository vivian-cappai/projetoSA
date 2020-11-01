package com.algaworks.osworks.api.controller;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

@RequestMapping("/clientes")
@RestController
public class ClienteController {
	/* injeção de dependencias*/
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	/*Listando todos os clientes*/
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepositorio.findAll();
	}
	
	/*Salvando cliente*/
	@PostMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		Cliente clienteRetorno = clienteRepositorio.save(cliente);
		return clienteRetorno;
	}
	
	/*Buscando cliente por id*/
	@GetMapping("/{id}")
	public Cliente buscarCliente(@PathVariable Long id) {
		return clienteRepositorio.findById(id).get();
	}
	
	/*Listando produtos por id do cliente*/
	@GetMapping("/{id}/produtos")
	public List <ProdutoDTO> getProdutoCliente(@PathVariable Long id){
		Cliente cliente = clienteRepositorio.findById(id).get();
		
		/*Transformando a lista de produtos em lista de produtosDTO*/
		return produtoRepositorio.findByCliente(cliente)
		 .stream()
		 .map(produto -> new ProdutoDTO(produto.getId(),produto.getNomeProduto(),produto.getQuantidade()))
		 .collect(Collectors.toList());
	}
}


