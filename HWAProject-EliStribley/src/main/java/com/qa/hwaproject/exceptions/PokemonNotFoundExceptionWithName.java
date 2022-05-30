package com.qa.hwaproject.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PokemonNotFoundExceptionWithName extends EntityNotFoundException {

	public PokemonNotFoundExceptionWithName(String name) {
		super("Pokemon does not exist with Name: " + name);
	}
	
}
