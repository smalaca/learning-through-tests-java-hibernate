package com.smalaca.simple;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void introduce() {
		Person sebastian = new Person("Sebastian");
		
		assertEquals("My name is Sebastian.", sebastian.introduce());
	}

}
