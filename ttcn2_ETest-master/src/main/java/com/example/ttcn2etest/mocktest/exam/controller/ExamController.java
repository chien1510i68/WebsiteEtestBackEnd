package com.example.ttcn2etest.mocktest.exam.controller;

import com.example.ttcn2etest.mocktest.exam.dto.DetailExamDTO;
import com.example.ttcn2etest.mocktest.exam.dto.ExamDTO;
import com.example.ttcn2etest.mocktest.exam.entity.Exam;
import com.example.ttcn2etest.mocktest.exam.request.ExamRequest;
import com.example.ttcn2etest.mocktest.exam.service.ExamService;
import com.example.ttcn2etest.mocktest.section.entity.Section;
import com.example.ttcn2etest.mocktest.section.request.SectionRequest;
import com.example.ttcn2etest.response.BaseItemResponse;
import com.example.ttcn2etest.response.BaseListItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client/mocktest/exam/")
public class ExamController {
    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }


    @PostMapping("create")
    public ResponseEntity<?> createExam(@RequestBody ExamRequest request) {
        Exam exam = examService.createExam(request);
        BaseItemResponse response = new BaseItemResponse();
        response.setSuccess(true);
        response.setData(exam);
        return ResponseEntity.ok(response);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateExam(@RequestBody ExamRequest request) {
        BaseItemResponse baseItemResponse = new BaseItemResponse();
        baseItemResponse.setSuccess();
        baseItemResponse.setData(examService.updateExam(request));
        return ResponseEntity.ok(baseItemResponse);

    }


    @GetMapping("{id}")
    public ResponseEntity<?> getExamByID(@PathVariable String id) {
        DetailExamDTO exam = examService.getByID(id);
        return ResponseEntity.ok(exam);
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable String id) {

        boolean isDelete = examService.deleteExam(id);
        return ResponseEntity.ok(isDelete);
    }

    @GetMapping("detailExams")
    public ResponseEntity<?> listDetailExam() {
        List<DetailExamDTO> detailExamDTOS = examService.listDetailExam();
        BaseListItemResponse response = new BaseListItemResponse();
        response.setResult(detailExamDTOS, detailExamDTOS.size());
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("addSection")
    public ResponseEntity<?> addSectionToExam(@RequestBody SectionRequest sectionRequest) {
        ExamDTO exam = examService.addSectionToExam(sectionRequest);
        BaseItemResponse response = new BaseItemResponse();
        response.setSuccess(true);
        response.setData(exam);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}/{type}")
    public ResponseEntity<?> findSections(@PathVariable String id, @PathVariable String type) {
        BaseListItemResponse response = new BaseListItemResponse();
        response.setSuccess(true);
        List<Section> sections = examService.findQuestionByType(id, type);
        response.setResult(sections, sections.size());
        return ResponseEntity.ok(response);

    }

    @GetMapping("file")
    public ResponseEntity<?> createExamByFile() {
        Exam exam = examService.createExamByExcel("test.xlsx");
        return ResponseEntity.ok(exam);
    }

    @GetMapping("/examService/{id}")
    public ResponseEntity<?> listExamByService (@PathVariable long id){
        return examService.getListExamByService(id);
    }
    @PostMapping("importFile")
    public ResponseEntity<?> readDataFormExcel(@RequestBody MultipartFile file ) {
        return examService.readExamFromExcel(file);
    }




}
