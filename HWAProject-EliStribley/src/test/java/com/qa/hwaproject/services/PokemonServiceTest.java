package com.qa.hwaproject.services;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.hwaproject.domain.Pokemon;
import com.qa.hwaproject.repos.PokemonRepo;

@SpringBootTest
public class PokemonServiceTest {

	@Autowired
	private PokemonService service;

	@MockBean
	private PokemonRepo repo;

	// Create Test
	@Test
	public void createTest() {
		Pokemon input = new Pokemon("Butterfree", "Bug", "Confusion", "Tackle");
		Pokemon output = new Pokemon(1L, "Butterfree", "Bug", "Confusion", "Tackle");

		Mockito.when(repo.saveAndFlush(input)).thenReturn(output);

		assertEquals(output, service.create(input));

		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(input);
	}

	// Read all Test
	@Test
	public void getAllTest() {
		List<Pokemon> output = new ArrayList<>();
		output.add(new Pokemon(1L, "Butterfree", "Bug", "Confusion", "Tackle"));

		Mockito.when(repo.findAll()).thenReturn(output);

		assertEquals(output, service.getAll());

		Mockito.verify(repo, Mockito.times(1)).findAll();
	}

	@Test
	public void getByIdTest() {

		Pokemon output = new Pokemon(1L, "Butterfree", "Bug", "Confusion", "Tackle");

		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(output));

		assertEquals(output, service.getById(1L));

		Mockito.verify(repo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void getByNameTest() {
		Pokemon existing = new Pokemon(1L, "Squirtle", "Water", "Bubble", "Tackle");
		
		Mockito.when(repo.findByName("Squirtle")).thenReturn(Optional.of(existing));

		assertEquals(existing, service.getByName("Squirtle"));

		Mockito.verify(repo, Mockito.times(1)).findByName("Squirtle");
	}

	// Update Test
	@Test
	public void updateTest() {

		Pokemon input = new Pokemon("Butterfree", "Bug", "Confusion", "Tackle");
		Optional<Pokemon> existing = Optional.of(new Pokemon(1L, "Squirtle", "Water", "Bubble", "Tackle"));
		Pokemon output = new Pokemon(1L, "Butterfree", "Bug", "Confusion", "Tackle");

		Mockito.when(repo.findById(1L)).thenReturn(existing);
		Mockito.when(repo.saveAndFlush(output)).thenReturn(output);

		assertEquals(output, service.update(1L, input));

		Mockito.verify(repo, Mockito.times(1)).findById(1L);
		Mockito.verify(repo, Mockito.times(1)).saveAndFlush(output);
	}

	// Delete Test
	// @Disabled
	@Test
	public void deleteTest() {
		final long Id = 1L;
		Mockito.when(repo.existsById(Id)).thenReturn(false);

		assertEquals(true, service.delete(1L));

		Mockito.verify(repo, Mockito.times(1)).deleteById(Id);
	}


	
}

