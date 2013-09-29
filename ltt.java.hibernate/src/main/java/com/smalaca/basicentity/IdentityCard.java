package com.smalaca.basicentity;

public class IdentityCard {

	private String name;
	private String address;
	
	public IdentityCard(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
