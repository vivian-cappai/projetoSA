package com.algaworks.osworks.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
	
	public List<Produto> findByCliente(Cliente cliente);
}


