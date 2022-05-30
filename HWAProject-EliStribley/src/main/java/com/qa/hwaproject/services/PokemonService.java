package com.qa.hwaproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hwaproject.domain.Pokemon;
import com.qa.hwaproject.exceptions.PokemonNotFoundExceptionWithID;
import com.qa.hwaproject.exceptions.PokemonNotFoundExceptionWithName;
import com.qa.hwaproject.repos.PokemonRepo;


public class PokemonService {

	private PokemonRepo repo;

    public PokemonService(PokemonRepo repo) {
        super();
        this.repo = repo;
    }

	
	//CREATE - Post Request

	public Pokemon create(Pokemon pokemon) {
		return this.repo.saveAndFlush(pokemon);
	}
    

	//READ - GET REQUEST ALL AND ID
	
	public List<Pokemon> getAll(){
		return repo.findAll();
	}
	

	public Pokemon getById(long id){
		return repo.findById(id).orElseThrow(() -> new PokemonNotFoundExceptionWithID(id));
	}
	public List<Pokemon> getByType(String type){
		return repo.findByType(type);
	}
	public Pokemon getByName(String name){
		return repo.findByName(name).orElseThrow(() -> new PokemonNotFoundExceptionWithName(name));
	}
	
	public List<Pokemon> getByMoveOne(String moveOne){
		return repo.findByMoveOne(moveOne);
	}
	
	public List<Pokemon> getByMoveTwo(String moveTwo){
		return repo.findByMoveTwo(moveTwo);
	}
	
	public Pokemon getByTypeAndMoveOne(String type, String moveOne){
		return repo.findByTypeAndMoveOne(type, moveOne).get();
	}
	
	
	//UPDATE - Put/Patch Request

	public Pokemon update(long id, Pokemon pokemon) {
		Pokemon existing = repo.findById(id).get();
		existing.setName(pokemon.getName());
		existing.setType(pokemon.getType());
		existing.setMoveOne(pokemon.getMoveOne());
		existing.setMoveTwo(pokemon.getMoveTwo());
		
		return repo.saveAndFlush(existing);
		
	}

	//DELETE - Delete Request

	public boolean delete(long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
		
	}
	
	
}
