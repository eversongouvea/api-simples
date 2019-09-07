package br.com.gouvea.api.web.place;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api Places.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/")
public class IndexController {

	@GetMapping()
	public ResponseEntity<String> index() {

		return ResponseEntity.ok().body("Api RestFull");
	}
	
	
}
