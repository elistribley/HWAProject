package com.qa.hwaproject.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PokemonNotFoundExceptionWithID extends NoSuchElementException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8552962401649555179L;

	public PokemonNotFoundExceptionWithID(long id) {
		super("Pokemon does not exist with ID: " + id);
	}
	
	
}
