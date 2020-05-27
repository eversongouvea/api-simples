package br.com.gouvea.api.domain.produto;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * services Produto.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
public interface ProdutoService {

	void create(Produto produto);
	
	void edit(Produto produto);
	
	void delete(Long id);
	
	Optional<Produto> findById(Long id); 
	
	Page<Produto> findPage(Pageable pageable);
	
}
