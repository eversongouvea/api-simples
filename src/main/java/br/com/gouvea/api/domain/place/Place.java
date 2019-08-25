package br.com.gouvea.api.domain.place;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


/**
 * Entity Place.
 * 
 * @author everson
 * @since 25/08/2019
 * @version 1.1
 */
@Entity(name = "place")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Inform name")
	private String name;
	
	@NotBlank(message="Inform slug")
	private String slug;
	
	@NotBlank(message="Inform city")
	private String city;
	
	@NotBlank(message="Inform state")
	private String state;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public String getSlug() {
		return slug;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	
	
}
