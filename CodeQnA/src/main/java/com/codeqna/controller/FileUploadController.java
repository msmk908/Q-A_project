package com.codeqna.controller;

import com.codeqna.dto.UploadFileDto;
import com.codeqna.entity.Uploadfile;
import com.codeqna.repository.UploadfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class FileUploadController {

    // 파일이 저장될 경로 설정
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private UploadfileRepository uploadfileRepository;

    @PostMapping("/upload")
    public ResponseEntity<UploadFileDto> uploadFile(@RequestParam("file") MultipartFile file){

        try {
            // 저장할 파일 경로 생성
            String originalFileName = file.getOriginalFilename();
            String savedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
            Path savedFilePath = Paths.get(uploadPath, savedFileName);

            // 파일 저장
            Files.createDirectories(savedFilePath.getParent());
            file.transferTo(savedFilePath.toFile());

            // 파일 정보 반환
            UploadFileDto fileDto = new UploadFileDto();
            fileDto.setOriginalFileName(originalFileName);
            fileDto.setSavedFileName(savedFileName);
            return ResponseEntity.status(HttpStatus.OK).body(fileDto);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
