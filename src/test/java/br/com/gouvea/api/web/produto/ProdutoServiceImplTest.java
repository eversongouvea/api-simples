package br.com.gouvea.api.web.produto;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.gouvea.api.domain.produto.Produto;
import br.com.gouvea.api.domain.produto.ProdutoRepository;

/**
 * Test Implements services Place.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceImplTest {

	@Mock
	private  ProdutoRepository placeRepository;
	
	@InjectMocks	
	private ProdutoServiceImpl service;
	
	@Test()
	public void TestCreatePlace()  {
		
		Produto place = new Produto();
		place.setNome("nome");
		place.setDescricao("descricao");
		place.setQuantidade(5);

		service.create(place);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestCreatePlaceWithId()  {
		
		Produto place = new Produto();
		
		place.setId(1L);
		
		service.create(place);
	}
	
	@Test()
	public void TestEditPlace()  {
		
		Produto place = new Produto();
		place.setId(1L);
		place.setNome("nome");
		place.setDescricao("descricao");
		place.setQuantidade(5);
		place.setCreated(LocalDateTime.now());
		
		Mockito.when(placeRepository.findById(1L)).thenReturn(Optional.of(place));
		
		place.setNome("New update");

		service.edit(place);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEditPlacewithoutId() {
		
		Produto place = new Produto();
		
		service.edit(place);
	}
	
}
