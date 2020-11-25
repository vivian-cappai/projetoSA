package com.rocket.osworks.domain.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
public class Produto {
	@Id
	//Delega a geração do ID para o banco(coluna auto-increment)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nomeProduto;
	private String quantidade;
	//relação 1 para N (um usuario para vários produtos)
	@ManyToOne
	//Fazendo join com a tabela cliente, pegando id do usuario. O "nullable = false" evita de cadastrar nulo
	@JoinColumn(name = "usuario_id",nullable=false)
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
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
}
