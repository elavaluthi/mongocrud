package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Task;
@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}