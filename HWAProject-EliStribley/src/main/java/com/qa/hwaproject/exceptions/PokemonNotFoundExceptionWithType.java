package com.qa.hwaproject.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PokemonNotFoundExceptionWithType extends EntityNotFoundException {
	
	public PokemonNotFoundExceptionWithType(String type) {
		super("Pokemon does not exist with Type: " + type);
	}
}