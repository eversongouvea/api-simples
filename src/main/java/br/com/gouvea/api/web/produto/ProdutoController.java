package br.com.gouvea.api.web.produto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gouvea.api.domain.produto.Produto;
import br.com.gouvea.api.domain.produto.ProdutoService;

/**
 * Api Produto.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	/**
	 * Lista paginada de Produto
	 * @return Page<Produto>
	 */
	@GetMapping()
	public ResponseEntity<Page<Produto>> findAll(Pageable pageable) {

		return ResponseEntity.ok().body(produtoService.findPage(pageable));
	}
	
	
	/**
	 * Consulta por id
	 * @param id
	 * @return Produto
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable  Long id) {

		return produtoService.findById(id)
				           .map(p -> ResponseEntity.ok(p))
				           .orElse(ResponseEntity.notFound().build());
	}
	
	
	/**
	 * Cadastra produto
	 * @param produto
	 * @return menssage
	 */
	@PostMapping
	@CacheEvict(value="produtoServiceFindPage",allEntries=true)
	public ResponseEntity<String> create(@Valid @RequestBody Produto produto,
			BindingResult result){
		
		if(result.hasErrors())
			throw new RuntimeException(result.getAllErrors().toString());
		
		produtoService.create(produto);
	
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Cadastrado com sucesso");
	}
	
	/**
	 * Atualizar 
	 * @param produto
	 * @return menssage
	 */
	@PutMapping
	@CacheEvict(value="produtoServiceFindPage",allEntries=true)
	public ResponseEntity<String> update(@Valid @RequestBody Produto produto, BindingResult result){

		if(result.hasErrors())
			throw new RuntimeException(result.getAllErrors().toString());
		
		produtoService.edit(produto);

		return ResponseEntity.ok("Atualizado com sucesso");
	}
	
	/**
	 * Deleta produto 
	 * @param id
	 * @return menssage
	 */
	@DeleteMapping(path = "/{id}")
	@CacheEvict(value="produtoServiceFindPage",allEntries=true)
	public ResponseEntity<String> update(@PathVariable  Long id){
		
		produtoService.delete(id);

		return ResponseEntity.ok("Deletado com sucesso");
	}
	
}
