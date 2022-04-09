package com.rxapps.reecifytest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

@RequestMapping("/musicinfo/jsons")
@RestController
public class APIController {

    @GetMapping(value = "/{filename}")
    public ResponseEntity<StreamingResponseBody> streamInfo(@PathVariable String filename) throws FileNotFoundException{
            File file = ResourceUtils.getFile("src/main/resources/jsons/" + filename);
            StreamingResponseBody responseBody = outputStream -> {
                Files.copy(file.toPath(), outputStream);
};
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseBody);
    }
    }