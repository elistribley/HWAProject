package com.qa.hwaproject.exceptions;

import javax.persistence.EntityNotFoundException;

public class PokemonNotFoundExceptionWithMoveOne extends EntityNotFoundException {

	public PokemonNotFoundExceptionWithMoveOne(String moveOne) {
		super("Pokemon does not exist with Move One: " + moveOne);
	}
	
}
