package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.File;
@Repository
public interface FileRepository extends MongoRepository<File, String> {
}
