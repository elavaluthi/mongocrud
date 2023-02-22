package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Generated;

@Document(collection = "tasks")
public class Task {
    @Id
    @Generated
    private String id;
    private String title;
    private int order;

    public Task(String title, int order) {
        this.title = title;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}