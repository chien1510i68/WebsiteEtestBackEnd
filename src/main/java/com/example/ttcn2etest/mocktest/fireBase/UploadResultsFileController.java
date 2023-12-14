package com.example.ttcn2etest.mocktest.fireBase;

import com.example.ttcn2etest.controller.BaseController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/results/file")
@RequiredArgsConstructor
public class FireBaseStorageController extends BaseController {
    private final UploadFileService uploadFileService;



    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@Valid @RequestPart("file") MultipartFile file) {
        try {
            String downloadUrl = uploadFileService.uploadFile(file);
            FirebaseUploadResponse response = new FirebaseUploadResponse(downloadUrl);
            return buildItemResponse(response);
        } catch (IOException e) {
            return buildResponse();
        }
    }

}
