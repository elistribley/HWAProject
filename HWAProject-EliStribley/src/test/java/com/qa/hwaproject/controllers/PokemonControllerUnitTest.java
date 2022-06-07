package com.qa.hwaproject.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwaproject.domain.Pokemon;
import com.qa.hwaproject.services.PokemonService;

@WebMvcTest
public class PokemonControllerUnitTest {
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private PokemonService service;
	
	//CREATE TESTS
	
	@Test
	void createTest() throws Exception {
		Pokemon entry = new Pokemon(2L, "Butterfree", "Bug", "Confusion", "Tackle");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/pokemon/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(entryAsJSON));
	}

	//READ TESTS
	@Test
	public void getAllTest() throws Exception {
		Pokemon entry = new Pokemon(2L, "Butterfree", "Bug", "Confusion", "Tackle");
		List<Pokemon> output = new ArrayList<>();
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		Mockito.when(this.service.getAll()).thenReturn(output);
		
		mvc.perform(get("/pokemon/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Pokemon entry = new Pokemon(1L, "Butterfree", "Bug", "Confusion", "Tackle");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.getById(1L)).thenReturn(entry);
		
		mvc.perform(get("/pokemon/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(entryAsJSON));
	}
	
	//UPDATE TEST
	@Test
	public void updateTest() throws Exception {
		Pokemon entry = new Pokemon("Butterfree", "Flying", "Confusion", "Tackle");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.update(1L, entry)).thenReturn(entry);
		
		mvc.perform(put("/pokemon/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(entryAsJSON));
	}
	
	//DELETE TESTS
	
	@Test
	public void deleteFailTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(false);
	
		mvc.perform(delete("/pokemon/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
	}
	


	@Test
	public void deletePassTest() throws Exception {
		Mockito.when(service.delete(1L)).thenReturn(true);
	
		mvc.perform(delete("/pokemon/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
}

}
