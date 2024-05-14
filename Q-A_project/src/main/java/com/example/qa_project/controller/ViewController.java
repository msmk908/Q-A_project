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

    @GetMapping("/filemanagement")
    public String filemanagement(){
        return "filemanagement";
    }

    @GetMapping("/boardlist")
    public String boardlist(){
        return "boardlist";
    }

}
