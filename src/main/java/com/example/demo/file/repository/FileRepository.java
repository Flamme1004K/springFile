package com.example.demo.file.repository;


import com.example.demo.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
