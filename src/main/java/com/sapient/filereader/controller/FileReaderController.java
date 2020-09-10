package com.sapient.filereader.controller;

import com.sapient.filereader.entity.USStatesEntity;
import com.sapient.filereader.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FileReaderController {

    @Autowired
    private CovidDataService service;

    @GetMapping("/getStatesData")
    public List<USStatesEntity> getUSStatesData(){
        return service.getUSStates();
    }

    @GetMapping("/getUSData")
    public List<USStatesEntity> getUSData(){
        return service.getUSData();
    }
}
