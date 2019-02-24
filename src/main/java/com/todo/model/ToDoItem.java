package com.todo.model;

import java.time.ZonedDateTime;
import java.util.Date;

public class ToDoItem {

    private long id;
    private String text;
    private boolean isCompleted;
    public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	private Date createdAt;

    public ToDoItem(long id, String text, boolean isCompleted, Date createdAt) {
        this.id = id;
        this.text = text;
        this.isCompleted = false;
        this.createdAt = null;
    }

    public long getId() {
        return id;
    }

 
    public void setItem(int id, String str, boolean isDone) {
        this.text = str;
        this.isCompleted = isDone;
        
    }

    public String getItem() {
        return text;
    }
}
