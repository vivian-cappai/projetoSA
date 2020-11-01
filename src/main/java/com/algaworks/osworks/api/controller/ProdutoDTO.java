package com.algaworks.osworks.api.controller;

/*Classe para expor as informações para o cliente da API*/
public class ProdutoDTO {
	private long id;
	private String nomeProduto;
	private String quantidade;
	
	public ProdutoDTO(long id, String nomeProduto, String quantidade) {
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
	}

	public long getId() {
		return id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public String getQuantidade() {
		return quantidade;
	}
	
	
}
