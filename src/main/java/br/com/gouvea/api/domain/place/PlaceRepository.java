package br.com.gouvea.api.domain.place;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Long> {

	 List<Place> findByName(String lastname);
	 
	 @Override
	 List<Place> findAll();
	
}
