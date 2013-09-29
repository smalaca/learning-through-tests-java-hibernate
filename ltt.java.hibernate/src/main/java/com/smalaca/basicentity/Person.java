package com.smalaca.basicentity;

public class Person {
	
	private String name;
	private String address;
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
