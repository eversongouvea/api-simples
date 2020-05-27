package br.com.gouvea.api.domain.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	 List<Produto> findByNome(String name);
	 
}
