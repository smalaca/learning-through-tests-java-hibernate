package com.smalaca.domain.enumeration;

public class Task {

	private Status status = Status.TODO;
	private Priority priority; 

	public Task() {
		this(Priority.MEDIUM);
	}
	
	public Task(Priority priority) {
		changePriority(priority);
	}

	public boolean checkStatus(Status status) {
		return this.status.equals(status);
	}

	public void startWorkingOn() {
		changeStatus(Status.IN_PROGRESS);
	}

	public void resolve() {
		changeStatus(Status.RESOLVED);
	}

	public void done() {
		changeStatus(Status.DONE);
	}

	public void revert() throws TaskException {
		if (checkStatus(Status.DONE))
			throw new TaskException("You cannot change status of task which was already done.");
			
		changeStatus(Status.TODO);
	}

	public Priority getPriority() {
		return priority;
	}

	public void changePriority(Priority priority) {
		this.priority = priority;
	}

	private void changeStatus(Status status) {
		this.status = status;
	}
}
