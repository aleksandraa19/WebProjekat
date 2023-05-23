package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.entity.StavkaPolice;
import com.example.demo.service.StavkaPoliceService;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StavkaPoliceRestController {

    @Autowired
    private StavkaPoliceService stavkaPoliceService;

}
