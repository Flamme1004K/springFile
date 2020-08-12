package com.example.demo.file.api;

import com.example.demo.file.domain.File;
import com.example.demo.file.dto.FileDto;
import com.example.demo.file.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@AllArgsConstructor
public class FileApiController {


    FileRepository fileRepository;

    @PostMapping(value="/saveImage")
    public ResponseEntity<String> saveImage(FileDto file) {
        try {
            fileRepository.save(File.builder().imgFile(file.getImgFile().getBytes()).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("추가 완료", HttpStatus.OK);
    }
}
