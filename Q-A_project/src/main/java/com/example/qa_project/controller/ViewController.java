package com.example.qa_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ViewController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/newboard")
    public String newboard(){
        return "newboard";
    }

}
