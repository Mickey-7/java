package com.example.uploadingfilesspringbootthymeleaf.service;

import com.example.uploadingfilesspringbootthymeleaf.advice.FileStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Value("${app.upload.dir:${C:\\Users\\donat\\Documents}}")
    public String uploadDir;

    public void uploadFile(MultipartFile file) {
        Path copyLocation = Paths.get(
                uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename())
        );

        try {
            // surround with try/catch on .getInputStream()
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            // invoke the exception
            throw new FileStorageException("Could not store file "+file.getOriginalFilename()+". Please try again!");

        }

    }
}
