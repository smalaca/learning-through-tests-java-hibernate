package com.smalaca.domain.enumeration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Task")
public class Task {

    @Id
    @GeneratedValue
    @Column(name="task_id")
    private int id;

    private String title;

    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.TODO;
    
    @Enumerated(EnumType.STRING)
    private Priority priority;

    public Task(String title) {
        this(title, Priority.MEDIUM);
    }

    public Task(String title, Priority priority) {
        this.title = title;
        changePriority(priority);
    }
    
    public String getTitle() {
        return title;
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
            throw new TaskException(
                    "You cannot change status of task which was already done.");

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
