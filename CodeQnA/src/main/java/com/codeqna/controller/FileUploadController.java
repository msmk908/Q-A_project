package com.codeqna.controller;

import com.codeqna.entity.Uploadfile;
import com.codeqna.repository.UploadfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    // 파일이 저장될 경로 설정
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private UploadfileRepository uploadfileRepository;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "파일이 비어 있습니다";
        }

        try {
            // 저장할 파일명 생성 (UUID로 고유한 파일명 생성)
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            // 저장할 파일 객체 생성
            File destFile = new File(uploadPath + File.separator + fileName);
            // 파일 저장
            file.transferTo(destFile);

            // 파일 업로드 성공 시 Uploadfile 엔티티에 저장
            Uploadfile uploadfile = new Uploadfile();
            uploadfile.setOriginal_file_name(file.getOriginalFilename());
            uploadfile.setSaved_file_name(fileName);
            uploadfileRepository.save(uploadfile);

            // 파일 업로드 성공 시 반환할 응답 메시지
            return "파일 업로드 성공: " + fileName;
        } catch (IOException e) {
            // 파일 업로드 실패 시 반환할 응답 메시지
            return "파일 업로드 실패: " + e.getMessage();
        }
    }

}
