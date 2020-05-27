package br.com.gouvea.api.web.produto;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.com.gouvea.api.domain.produto.Produto;
import br.com.gouvea.api.domain.produto.ProdutoRepository;
import br.com.gouvea.api.domain.produto.ProdutoService;

/**
 * Implements services Produto.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void create(Produto produto) {

		Assert.isNull(produto.getId(), "Parametro ID não pode ser informado");

		produto.setUpdated(null);
		produto.setCreated(LocalDateTime.now());
		produtoRepository.save(produto);

	}

	@Transactional
	@Override
	public void edit(Produto produto) {

		Assert.notNull(produto.getId(), "Informar parametro ID!");

		produtoRepository.findById(produto.getId()).map(p -> {
			p.setUpdated(LocalDateTime.now());
			p.setDescricao(produto.getDescricao());
			p.setNome(produto.getNome());
			p.setQuantidade(produto.getQuantidade());
			return p;
		}).orElseThrow(() -> new RuntimeException("Id não localizado"));

	}
	
	@Override
	public Optional<Produto> findById(Long id) {

		return produtoRepository.findById(id);
	}

	@Cacheable("produtoServiceFindPage") 
	@Override
	public Page<Produto> findPage(
			@PageableDefault(sort = "id", direction = Direction.ASC, size = 10, page = 0) Pageable pageable) {

		return produtoRepository.findAll(pageable);

	}

	@Override
	public void delete(Long id) {
		
		produtoRepository.deleteById(id);
		
	}

}
