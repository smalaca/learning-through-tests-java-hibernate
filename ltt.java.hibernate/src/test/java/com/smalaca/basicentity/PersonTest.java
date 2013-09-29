package com.smalaca.basicentity;

import static org.junit.Assert.*;
import org.junit.Test;
import com.smalaca.basicentity.Person;

public class PersonTest {

	@Test
	public void introduce() {
		String name = "Sebastian Malaca";
		String address = "Cracow, Poland";
		Person sebastian = new Person(name, address);

		assertEquals(name, sebastian.getID().getName());
		assertEquals(address, sebastian.getID().getAddress());
	}
	
	@Test
	public void changeAddress() {
		Person sebastian = new Person("Sebastian Malaca", "Cracow, Poland");
		String newAdderss = "New York, USA";
		
		sebastian.changeAddress(newAdderss);
		
		assertEquals(newAdderss, sebastian.getID().getAddress());
	}
}
