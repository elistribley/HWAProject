package com.qa.hwaproject.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwaproject.domain.Pokemon;
import com.qa.hwaproject.services.PokemonService;


@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	private PokemonService service;
	
	public PokemonController(PokemonService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Pokemon>> getAll() {
		return new ResponseEntity<List<Pokemon>>(service.getAll(), HttpStatus.ACCEPTED);
	}
	
	
	//Read Id
	@GetMapping("/getById/{id}")
	public ResponseEntity<Pokemon> getById(@PathVariable long id) {
		return new ResponseEntity<Pokemon>(service.getById(id), HttpStatus.ACCEPTED);
			
	}
	//Read Type
	@GetMapping("/getByType/{type}")
	public ResponseEntity<List<Pokemon>> getByType(@PathVariable String type) {
		return new ResponseEntity<List<Pokemon>>(service.getByType(type), HttpStatus.ACCEPTED);
				
	}
	
	//Read Name
	@GetMapping("/getByName/{name}")
	public ResponseEntity<Pokemon> getByName(@PathVariable String name) {
		return new ResponseEntity<Pokemon>(service.getByName(name), HttpStatus.ACCEPTED);
				
	}
	//Read Move One
	@GetMapping("/getByMoveOne/{moveOne}")
	public ResponseEntity<List<Pokemon>> getByMoveOne(@PathVariable String moveOne) {
		return new ResponseEntity<List<Pokemon>>(service.getByMoveOne(moveOne), HttpStatus.ACCEPTED);
				
	}
	
	@GetMapping("/getByMoveTwo/{moveTwo}")
	public ResponseEntity<List<Pokemon>> getByMoveTwo(@PathVariable String moveTwo) {
		return new ResponseEntity<List<Pokemon>>(service.getByMoveTwo(moveTwo), HttpStatus.ACCEPTED);
				
	}
	
	@GetMapping("/getByTypeAndMoveOne/{type}, {moveOne}")
	public ResponseEntity<Pokemon> getByTypeAndMoveOne(@PathVariable String type, String moveOne) {
		return new ResponseEntity<Pokemon>(service.getByTypeAndMoveOne(type, moveOne), HttpStatus.ACCEPTED);
				
	}
	
	//CREATE - Post Request - @PostMapping
	@PostMapping("/create")
	public ResponseEntity<Pokemon> create(@RequestBody Pokemon pokemon) {
		return new ResponseEntity<Pokemon>(service.create(pokemon), HttpStatus.CREATED);
	
	}
	
	//UPDATE - Put/Patch Request - @PutMapping
	@PutMapping("/update/{id}")
	public ResponseEntity<Pokemon> update(@PathVariable long id, @RequestBody Pokemon pokemon) {
		return new ResponseEntity<Pokemon>(service.update(id, pokemon), HttpStatus.ACCEPTED);
	
	}
	
	
	
	//DELETE - Delete Request - @DeleteMapping
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		
		return service.delete(id) ? new ResponseEntity<Boolean>(service.delete(id), HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
	}
		

}