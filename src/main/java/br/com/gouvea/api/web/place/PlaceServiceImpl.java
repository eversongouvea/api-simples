package br.com.gouvea.api.web.place;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.gouvea.api.domain.place.Place;
import br.com.gouvea.api.domain.place.PlaceRepository;
import br.com.gouvea.api.domain.place.PlaceService;


/**
 * Implements services Place.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@Service
public class PlaceServiceImpl  implements PlaceService{

	@Autowired
	private  PlaceRepository placeRepository;
	
	@Override
	public void create(Place place) {
		
		Assert.isNull(place.getId(), "Id must be empty!");
		
		place.setUpdated(null);
		place.setCreated(LocalDateTime.now());
		placeRepository.save(place);
		
	}

	@Override
	public void edit(Place place) {
		
		Assert.notNull(place.getId(), "The id was not specified!");

		placeRepository.findById(place.getId()).map(p -> {
			place.setUpdated(LocalDateTime.now());
			place.setCreated(p.getCreated());
			placeRepository.save(place);
			return p;
		}).orElseThrow(() -> new RuntimeException("Id not found") );

	}

	@Override
	public Optional<Place> findById(Long id) {
		
		return placeRepository.findById(id);
	}

	@Override
	public List<Place> findAllByName(String name) {
		
		return placeRepository.findByName(name);
	}

	
	@Override
	public List<Place> findAll() {
		
		return placeRepository.findAll();
	}

}
