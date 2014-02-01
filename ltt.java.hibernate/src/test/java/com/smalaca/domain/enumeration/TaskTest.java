package com.smalaca.domain.enumeration;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TaskTest {

	@Test
	public void newTaskWithToDoStatusAndDefaultPriority() {
		String coffee = "Drink coffee";
        Task task = new Task(coffee);
		
        assertEquals(coffee, task.getTitle());
		assertTrue(task.checkStatus(Status.TODO));
		assertEquals(Priority.MEDIUM, task.getPriority());
	}
	
	@Test
	public void taskInProgress() {
		Task task = new Task("Write some code");
		task.startWorkingOn();
		
		assertTrue(task.checkStatus(Status.IN_PROGRESS));
	}
	
	@Test
	public void resolvedTaks() {
		Task task = new Task("Write a blog post");
		task.resolve();
		
		assertTrue(task.checkStatus(Status.RESOLVED));
	}
	
	@Test
	public void doneTask() {
		Task task = new Task("Don't forget about tests!");
		task.done();
		
		assertTrue(task.checkStatus(Status.DONE));	
	}
	
	@Test
	public void revertStatusIntoToDo() throws TaskException {
		Task task = new Task("Go to sleep before 2 am.");
		task.startWorkingOn();
		task.revert();
		
		assertTrue(task.checkStatus(Status.TODO));
		
		task.resolve();
		task.revert();
		
		assertTrue(task.checkStatus(Status.TODO));

		task.revert();
		
		assertTrue(task.checkStatus(Status.TODO));
	}
	
	@Rule 
	public ExpectedException thrown= ExpectedException.none();

	@Test
	public void cannotRevertStatusOfDoneTask() throws TaskException {
		Task task = new Task("Read a couple page of book");
		task.done();
		
		thrown.expect(TaskException.class);
	    thrown.expectMessage("You cannot change status of task which was already done.");
	    
		task.revert();
	}
	
	@Test
	public void createTaskWithDifferentPriority() {
		assertEquals(Priority.LOW, new Task("Do this", Priority.LOW).getPriority());
		assertEquals(Priority.HIGH, new Task("Do that", Priority.HIGH).getPriority());
	}
	
	@Test
	public void changePriority() {
		Task task = new Task("Take small steps");
		task.changePriority(Priority.LOW);
		
		assertEquals(Priority.LOW, task.getPriority());
		
		task.changePriority(Priority.HIGH);
		assertEquals(Priority.HIGH, task.getPriority());
	}
}
