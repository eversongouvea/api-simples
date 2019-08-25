package br.com.gouvea.api.web.place;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.gouvea.api.domain.place.Place;
import br.com.gouvea.api.domain.place.PlaceRepository;

/**
 * Test Implements services Place.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@RunWith(MockitoJUnitRunner.class)
public class PlaceServiceImplTest {

	@Mock
	private  PlaceRepository placeRepository;
	
	@InjectMocks	
	private PlaceServiceImpl service;
	
	@Test()
	public void TestCreatePlace()  {
		
		Place place = new Place();
		place.setName("name");
		place.setSlug("slug");
		place.setState("state");
		place.setCity("city");

		service.create(place);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestCreatePlaceWithId()  {
		
		Place place = new Place();
		
		place.setId(1L);
		
		service.create(place);
	}
	
	@Test()
	public void TestEditPlace()  {
		
		Place place = new Place();
		place.setId(1L);
		place.setName("name");
		place.setSlug("slug");
		place.setState("state");
		place.setCity("city");
		place.setCreated(LocalDateTime.now());
		
		Mockito.when(placeRepository.findById(1L)).thenReturn(Optional.of(place));
		
		place.setName("New update");

		service.edit(place);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEditPlacewithoutId() {
		
		Place place = new Place();
		
		service.edit(place);
	}
	
}
