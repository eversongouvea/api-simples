package br.com.gouvea.api.domain.place;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {

	 List<Place> findByName(String lastname);
	 
	 @Override
	 List<Place> findAll();
	 
	 Page<Place> findPageByName(String lastname,Pageable pageable);
	
}
