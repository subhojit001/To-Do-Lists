package com.project.ToDo_Lists;

import jakarta.persistence.*;

@Entity
@Table(name = "todotable")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String task;
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean setStatus(boolean status) {
        return this.status = status;
    }
}
