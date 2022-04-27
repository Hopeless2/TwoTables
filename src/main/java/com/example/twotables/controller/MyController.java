package com.example.twotables.controller;

import com.example.twotables.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class MyController {
    @Autowired
    MyRepository repository;

    public MyController (MyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public String getName(String name) {
        return repository.getProductName(name);
    }
}
