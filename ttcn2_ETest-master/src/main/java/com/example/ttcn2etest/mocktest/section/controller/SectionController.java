package com.example.ttcn2etest.mocktest.section.controller;

import com.example.ttcn2etest.mocktest.section.service.SectionService;
import com.example.ttcn2etest.response.BaseItemResponse;
import com.example.ttcn2etest.response.BaseListItemResponse;
import com.example.ttcn2etest.mocktest.section.entity.Section;
import com.example.ttcn2etest.mocktest.section.request.SectionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mocktest/section/")
public class SectionController {
    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping("create")
    public ResponseEntity<?> createSection(@RequestBody SectionRequest request) {
        Section section = sectionService.createSection(request);
        BaseItemResponse response = new BaseItemResponse();
        response.setSuccess(true);
        response.setData(section);
        return ResponseEntity.ok(response);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateSection(@RequestBody SectionRequest sectionRequest) {
        Section section = sectionService.updateSection(sectionRequest);
        BaseItemResponse baseItemResponse = new BaseItemResponse();
        baseItemResponse.setData(section);
        baseItemResponse.setSuccess(true);
        return ResponseEntity.ok(baseItemResponse);

    }
    @DeleteMapping("del/{id}")
    public ResponseEntity<?> deleteSection (@PathVariable String id){
        boolean isDelete = sectionService.deleteSection(id);
//        BaseItemResponse baseItemResponse = new BaseItemResponse();
//        baseItemResponse.setSuccess();
//        baseItemResponse.setData(isDelete);
        return ResponseEntity.ok(isDelete);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllSection() {
        List<Section> sections = sectionService.getAllSection();
        BaseListItemResponse response = new BaseListItemResponse();
        response.setSuccess(true);
        response.setResult(sections, sections.size());
        return ResponseEntity.ok(response);
    }


}
