package com.jtodo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoEntry {
    @Id
    private int id;
    private String title;
    private String description;
    private TodoStatus status;

    public TodoEntry() {}

    public TodoEntry(int id, String title, String description, TodoStatus status) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + id;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        TodoEntry other = (TodoEntry) obj;

        if (description == null) {
            if (other.description != null)
                return false;
        }
        else if (!description.equals(other.description)) {
            return false;
        }

        if (id != other.id)
            return false;
        if (status != other.status)
            return false;

        if (title == null) {
            if (other.title != null)
                return false;
        }
        else if (!title.equals(other.title)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "TodoEntry [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status + "]";
    }
}