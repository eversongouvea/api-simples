package br.com.gouvea.api.domain.place;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


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
	
	Page<Place> findPage(String name, Pageable pageable);
	
	List<Place> findAll();
	
	List<Place> findAllByName(String name);
	
}
