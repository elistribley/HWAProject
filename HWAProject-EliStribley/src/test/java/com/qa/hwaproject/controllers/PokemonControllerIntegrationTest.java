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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwaproject.domain.Pokemon;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class PokemonControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Test
	public void createTest() throws Exception {
		Pokemon input = new Pokemon(1L, "Butterfree", "Bug", "Confusion", "Tackle");
		String inputAsJSON = mapper.writeValueAsString(input);
		
		Pokemon output = new Pokemon(1L, "Butterfree", "Bug", "Confusion", "Tackle");
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(post("/pokemon/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(outputAsJSON));
		
	}
	@Test
	public void getAllTest() throws Exception {
		Pokemon pokemon = new Pokemon(1L,"Butterfree", "Bug", "Confusion", "Tackle");
		List<Pokemon> output = new ArrayList<>();
		output.add(pokemon);
		
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/pokemon/getAll")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void getByIdTest() throws Exception {
		Pokemon entry = new Pokemon(1L,"Butterfree", "Bug", "Confusion", "Tackle");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/pokemon/getById/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Pokemon entry = new Pokemon("Butterfree", "Bug", "Confusion", "Tackle");
		Pokemon result = new Pokemon(1L,"Butterfree", "Bug", "Confusion", "Tackle");
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/pokemon/update/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isAccepted())
			.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		
		mvc.perform(delete("/pokemon/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}
	
}
