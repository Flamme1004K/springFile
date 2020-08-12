package com.example.demo.file.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Lob
    private byte[] imgFile;

}
