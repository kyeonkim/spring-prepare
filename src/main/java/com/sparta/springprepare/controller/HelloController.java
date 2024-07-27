package com.sparta.springprepare.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping()
    @ResponseBody
    public String get() {
        return "GET Method Request";
    }

    @PostMapping()
    @ResponseBody
    public String post() {
        return "Post Method Request";
    }

    @PutMapping()
    @ResponseBody
    public String put() {
        return "Put Method Request";
    }

    @DeleteMapping()
    @ResponseBody
    public String delete() {
        return "Delete Method Request";
    }
}
