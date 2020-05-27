package br.com.gouvea.api.domain.produto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * Entity Produto.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@Data
@Entity(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Informar nome")
	private String nome;
	
	@NotBlank(message="Informar descricao")
	private String descricao;
	
	@NotNull(message="Informmar quantidade")
	private Integer quantidade;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
}
