//package com.example.demosetupproject.controller;
//
//import com.example.demosetupproject.controller.dtos.FileUploadResponse;
//import com.example.demosetupproject.service.FileStorageService;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//
//
////Uploading: with two end-points: single file and multiple file upload
////Downloading: with two end-pooints: single and multiple file download (Zip)
//@RestController
//public class UploadDownloadWithFileSystemController {
//    private FileStorageService fileStorageService;
//
//    public UploadDownloadWithFileSystemController(FileStorageService fileStorageService) {
//        this.fileStorageService = fileStorageService;
//    }
//
//    @PostMapping("single/upload/")
//    FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download")
//                .path(fileName)
//                .toUriString();
//
//        String contentType = file.getContentType();
//
//        FileUploadResponse response = new FileUploadResponse(fileName, contentType, url);
//
//        return response;
//    }
//
//    @GetMapping("/download/{fileName}")
//    ResponseEntity<Resource> downloadSingleFile(@PathVariable String fileName, HttpServletRequest request) {
//        Resource resource = fileStorageService.downloadFile(fileName);
//
//        MediaType contentType = MediaType.IMAGE_JPEG;
//        return new ResponseEntity.ok()
//                .contentType(contentType)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement;fileName=" + resource.getFilename())
//                .body(resource);
//    }
//}
