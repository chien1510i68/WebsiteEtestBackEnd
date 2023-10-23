package com.example.ttcn2etest.mocktest.exam.repository;

import com.example.ttcn2etest.mocktest.exam.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {
    Exam findExamById(String id );
    List<Exam> findExamsByType(String type);


}
