package com.sparta.springprepare.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestfulApiController {

    @GetMapping()
    public String get() {
        return "GET Method Request";
    }

    @PostMapping()
    public String post() {
        return "Post Method Request";
    }

    @PutMapping()
    public String put() {
        return "Put Method Request";
    }

    @DeleteMapping()
    public String delete() {
        return "Delete Method Request";
    }
}
