package com.qa.hwaproject.domain;



import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;


//                  ------- DECIDED AGAINST USING LOMBOK ------
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Data
//@EqualsAndHashCode
@Entity
public class Pokemon {
	
	@Id //WILL BE PRIMARY KEY - UNIQUE AND NOT NULL
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	
	@Column(name = "name", nullable = false, unique = true)
	@Size(min = 2, max = 20)
	private String name = "Squirtle";
	
	@Column(name = "type", nullable = false)
	@Size(min = 2, max = 20)
	private String type;
	
	@Column(name = "moveone", nullable = false)
	@Size(min = 2, max = 20)
	private String moveOne;
	
	@Column(name = "movetwo", nullable = false)
	@Size(min = 2, max = 20)
	private String moveTwo;
	
	//@Column(name="img", nullable = true)
	//private String url = "";
	
	//CONSTRUCTORS
	
	public Pokemon(long id, String name, String type, String moveOne, String moveTwo) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.moveOne = moveOne;
		this.moveTwo = moveTwo;
	}

	public Pokemon(String name, String type, String moveOne, String moveTwo) {
		super();
		this.name = name;
		this.type = type;
		this.moveOne = moveOne;
		this.moveTwo = moveTwo;

	}
	
	public Pokemon() {
		super();
	}
	
	//GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMoveOne() {
		return moveOne;
	}

	public void setMoveOne(String moveOne) {
		this.moveOne = moveOne;
	}

	public String getMoveTwo() {
		return moveTwo;
	}

	public void setMoveTwo(String moveTwo) {
		this.moveTwo = moveTwo;
	}
	
	//HASHCODE AND EQUALS TO

	@Override
	public int hashCode() {
		return Objects.hash(id, name, type, moveOne, moveTwo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return  Objects.equals(id, other.id)
				&& Objects.equals(moveOne, other.moveOne) && Objects.equals(moveTwo, other.moveTwo)
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}


	
}