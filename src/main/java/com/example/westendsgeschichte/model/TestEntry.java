package com.example.westendsgeschichte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestEntry {

    @Id
    private String id;

    private String message;

    public TestEntry() {}

    public TestEntry(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() { return id; }
    public String getMessage() { return message; }

    public void setId(String id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
}
