package com.qa.hwaproject.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.hwaproject.domain.Pokemon;


@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {

	
	Optional<Pokemon> findById(Long id);
	
	//SELECT * FROM pokemon WHERE type =?
	List<Pokemon> findByType(String type);

	//SELECT * FROM pokemon WHERE moveOne =?
	List<Pokemon> findByMoveOne(String moveOne);
	
	//SELECT * FROM pokemon WHERE moveOne =?
	List<Pokemon> findByMoveTwo(String moveTwo);
	
	// SELECT * from Pokemon where type = '[type]' and moveOne = [moveOne];
	Optional<Pokemon> findByTypeAndMoveOne(String type, String moveOne);
	
	// SELECT * from Pokemon where type = '[type]' and moveTwo = [moveTwo];
	Optional<Pokemon> findByTypeAndMoveTwo(String type, String moveTwo);
	
	
	
//	SELECT * FROM pokemon WHERE name =?
//	Pokemon findByName(String Name);
	@Query(value = "SELECT * FROM pokemon WHERE name = ?", nativeQuery=true)
	Optional<Pokemon> findByName(String name);

	
	
}