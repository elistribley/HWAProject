package com.qa.hwaproject.exceptions;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Pokemon does not exist with that name")
public class PokemonNotFoundException extends NoSuchElementException {


	
	
}
