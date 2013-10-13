package com.smalaca.basicentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue
	@Column(name="person_id")
	private int id;
	
	private String name;
	
	@Column(name="home_address")
	private String address;
	
	@Transient
	private IdentityCard identityCard;

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
		
		identityCard = new IdentityCard(name, this.address);
	}

	public IdentityCard getID() {
		return identityCard;
	}

	public void changeAddress(String newAdderss) {
		identityCard = new IdentityCard(name, newAdderss);
	}
}
