package com.example.ttcn2etest.mocktest.user_exam.service;

import com.example.ttcn2etest.mocktest.user_exam.dto.UserResultsDTO;
import com.example.ttcn2etest.mocktest.user_exam.request.FilterUserResnponseRequest;
import com.example.ttcn2etest.mocktest.user_exam.request.StatisticResultsRequest;
import com.example.ttcn2etest.mocktest.user_exam.request.UserResultsRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserResultsService {
    ResponseEntity<?> getUserResultsDetail (String id );

    ResponseEntity<?> getListUserResults (UserResultsRequest resultsRequest) ;
    ResponseEntity<?> listUserResultsByUserResponseId(String userResponseId);

    ResponseEntity<?> sortUserResultsASC(FilterUserResnponseRequest request) ;
    ResponseEntity<?> sortUserResultsDESC(FilterUserResnponseRequest request) ;
    ResponseEntity<?> listResultsByExam(StatisticResultsRequest request) ;
}
