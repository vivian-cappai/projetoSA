package com.algaworks.osworks.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*Transforma em entidade do JPA*/
@Entity
public class Produto {
	/*Cria ID*/
	@Id
	/*Delega a geração do ID para o banco(coluna auto-increment)*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeProduto;
	private String quantidade;
	/*relação 1 para N (um cliente para vários produtos)*/
	@ManyToOne
	/*Fazendo join com a tabela cliente, pegando id do cliente. O "nullable = false" evita de cadastrar nulo*/
	@JoinColumn(name = "cliente_id",nullable=false)
	private Cliente cliente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
