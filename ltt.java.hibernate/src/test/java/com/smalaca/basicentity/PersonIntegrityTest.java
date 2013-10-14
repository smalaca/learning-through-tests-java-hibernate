package com.smalaca.basicentity;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import com.smalaca.dbhandler.HibernateUtil;

public class PersonIntegrityTest {
	private final Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Test
	public void createAndRead() {
        session.beginTransaction();

		Person sebastian = new Person("Sebastian Malaca", "Cracow, Poland");
		Person junior = new Person("Sebastian Junior", "Cracow, Poland");

		Integer sebastianId = (Integer) session.save(sebastian);
		Integer juniorId = (Integer) session.save(junior);

		Person sebastianFromDb = (Person) session.get(Person.class, sebastianId);
		Person juniorFromDb = (Person) session.get(Person.class, juniorId);

		assertTrue(sebastian.equals(sebastianFromDb));
		assertTrue(junior.equals(juniorFromDb));
		assertFalse(sebastianFromDb.equals(juniorFromDb));
		
		session.getTransaction().rollback();
		session.close();
	}
	
	@Test
	public void update() {
        session.beginTransaction();

		Person sebastian = new Person("Sebastian Malaca", "Cracow, Poland");
		Integer sebastianId = (Integer) session.save(sebastian);

		Person sebastianFromDb = (Person) session.get(Person.class, sebastianId);
		
		String newAdderss = "New York, USA";
		sebastian.changeAddress(newAdderss);
		session.update(sebastian);

		Person sebastianFromDbAfterUpdate = (Person) session.get(Person.class, sebastianId);

		assertTrue(sebastian.equals(sebastianFromDb));
		assertTrue(sebastianFromDb.equals(sebastianFromDbAfterUpdate));
		assertTrue(sebastian.equals(sebastianFromDbAfterUpdate));
		assertEquals(newAdderss, sebastian.getID().getAddress());
		
		session.getTransaction().rollback();
		session.close();
	}
	
	@Test
	public void delete() {
        session.beginTransaction();

		Person sebastian = new Person("Sebastian Malaca", "Cracow, Poland");
		Integer sebastianId = (Integer) session.save(sebastian);

		session.delete(sebastian);
		
		Person notExisting = (Person) session.get(Person.class, sebastianId);

		assertNull(notExisting);
		
		session.getTransaction().rollback();
		session.close();
	}
}
