package com.example.demo.Service;

import com.example.demo.Repository.FileRepository;
import com.example.demo.model.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public Optional<File> getFileById(String id) {
        return fileRepository.findById(id);
    }

    public void saveFile(MultipartFile file) throws IOException {
        File dbFile = new File(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getSize(),
                file.getBytes()
        );
        fileRepository.save(dbFile);
    }

    public void deleteFileById(String id) {
        Optional<File> file = fileRepository.findById(id);
        file.ifPresent(f -> fileRepository.delete(f));
    }
}