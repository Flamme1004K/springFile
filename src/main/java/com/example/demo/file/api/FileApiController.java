package com.example.demo.file.api;

import com.example.demo.file.domain.File;
import com.example.demo.file.dto.FileDto;
import com.example.demo.file.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@AllArgsConstructor
public class FileApiController {

    FileRepository fileRepository;

    @PostMapping(value="/saveImage")
    public ResponseEntity<String> saveImage(@RequestParam MultipartFile file) throws IOException {
        fileRepository.save(File.builder().imgFile(file.getBytes()).build());
        return new ResponseEntity<String>("추가 완료", HttpStatus.OK);
    }

    @GetMapping(value="/getByteImage")
    public ResponseEntity<byte[]> getByteImage() {
        File file = fileRepository.findById(1L).get();
        byte[] imageContent = (byte[]) file.getImgFile();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }


}
