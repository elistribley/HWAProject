package com.qa.hwaproject.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PokemonNotFoundExceptionWithName extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8231497432750651306L;

	public PokemonNotFoundExceptionWithName(String name) {
		super("Pokemon does not exist with Name: " + name);
	}
	
}
