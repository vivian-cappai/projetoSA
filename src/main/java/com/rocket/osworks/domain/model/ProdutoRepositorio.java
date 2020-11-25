package com.rocket.osworks.domain.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
	//public List<Produto> findByUsuario(Usuario usuario);
}
