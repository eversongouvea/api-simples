package br.com.gouvea.api.domain.place;

import java.util.List;
import java.util.Optional;


/**
 * services Place.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
public interface PlaceService {

	void create(Place place);
	
	void edit(Place place);
	
	Optional<Place> findById(Long id); 
	
	List<Place> findAll();
	
	List<Place> findAllByName(String name);
	
}
