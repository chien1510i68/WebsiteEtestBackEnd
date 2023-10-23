package com.example.ttcn2etest.mocktest.exam.request;

import com.example.ttcn2etest.mocktest.section.request.SectionRequest;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data

public class ExamRequest {
    private  String name ;
    private String id ;
    private long timeExam ;
    List<SectionRequest> sectionRequests ;

}
