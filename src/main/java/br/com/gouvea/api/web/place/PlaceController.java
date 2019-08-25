package br.com.gouvea.api.web.place;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gouvea.api.domain.place.Place;
import br.com.gouvea.api.domain.place.PlaceService;

/**
 * Api Places.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/places")
public class PlaceController {

	@Autowired
	private PlaceService placeService;
	
	/**
	 * Consulting all
	 * @return List<Place>
	 */
	@GetMapping()
	public ResponseEntity<List<Place>> findAll() {

		return ResponseEntity.ok().body(placeService.findAll());
	}
	
	/**
	 * Querying by name
	 * @param name
	 * @return List<Place>
	 */
	@GetMapping(path = "/name/{name}")
	public ResponseEntity<List<Place>> findAllByName(@PathVariable String name) {

		return ResponseEntity.ok().body(placeService.findAllByName(name));
	}
	
	
	/**
	 * Querying by id
	 * @param id
	 * @return List<Place>
	 */
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Place> findById(@PathVariable  Long id) {

		return placeService.findById(id)
				           .map(p -> ResponseEntity.ok(p))
				           .orElse(ResponseEntity.notFound().build());
	}
	
	
	/**
	 * Create
	 * @param place
	 * @return menssage
	 */
	@PostMapping
	public ResponseEntity<String> create(@Valid @RequestBody Place place,
			BindingResult result){
		
		if(result.hasErrors())
			throw new RuntimeException(result.getAllErrors().toString());
		
		placeService.create(place);
	
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Create success");
	}
	
	
	/**
	 * Update
	 * @param place
	 * @return menssage
	 */
	@PutMapping
	public ResponseEntity<String> update(@Valid @RequestBody Place place, BindingResult result){

		if(result.hasErrors())
			throw new RuntimeException(result.getAllErrors().toString());
		
		this.placeService.edit(place);


		return ResponseEntity.ok("Update success");
	}
	
}
