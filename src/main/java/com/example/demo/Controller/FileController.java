package com.example.demo.Controller;

import com.example.demo.Service.FileService;
import com.example.demo.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/files")
public class FileController {
	

    @Autowired
    private FileService fileService;

    @GetMapping("")
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @PostMapping("")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.saveFile(file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<File> getFileById(@PathVariable String id) {
        Optional<File> file = fileService.getFileById(id);
        if (file.isPresent()) {
            return new ResponseEntity<>(file.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}