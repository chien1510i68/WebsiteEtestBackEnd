package com.example.ttcn2etest.mocktest.user_exam.controller;

import com.example.ttcn2etest.mocktest.user_exam.request.FilterUserResnponseRequest;
import com.example.ttcn2etest.mocktest.user_exam.request.StatisticResultsRequest;
import com.example.ttcn2etest.mocktest.user_exam.service.UserResultsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client/mocktest/results/")
@RequiredArgsConstructor
public class UserResultsController {
    private final UserResultsService userResultsService;

    @GetMapping("responseId/{id}")
    public ResponseEntity<?> getAllResultsByResponseId(@PathVariable String id) {
        return ResponseEntity.ok(userResultsService.listUserResultsByUserResponseId(id));

    }
    @GetMapping("{id}")
    public ResponseEntity<?> getResultsUser(@PathVariable String id){
        return ResponseEntity.ok(userResultsService.getUserResultsDetail(id));
    }
    @PostMapping("filter")
    public ResponseEntity<?> filterResultsASC(@RequestBody FilterUserResnponseRequest request){
//        return ResponseEntity.ok(userResultsService.sortUserResultsASC(request));
        return ResponseEntity.ok(userResultsService.sortUserResultsDESC(request));
    }

    @PostMapping("statistic")
    public ResponseEntity<?> listResultsByExam(@RequestBody StatisticResultsRequest request){
        return ResponseEntity.ok().body(userResultsService.listResultsByExam(request));
    }

}
