package br.com.gouvea.api.web.produto;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Api.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@RestController
@RequestMapping(path = "/")
public class IndexController {

	@ApiIgnore
	@GetMapping()
	public void index(HttpServletResponse response) throws IOException{

		response.sendRedirect("/swagger-ui.html");
	}
	
	
}
