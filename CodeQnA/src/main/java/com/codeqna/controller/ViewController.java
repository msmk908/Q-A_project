package com.codeqna.controller;


import com.codeqna.dto.BoardViewDto;
import com.codeqna.entity.Board;
import com.codeqna.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ViewController {

//    @GetMapping("/main")
//    public String mainpage(){
//        return "mainpage";
//    }

    private final BoardService boardservice;

    @GetMapping("/main")
    public String mainpage(){
        return "boardlist";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "user/signup";
    }

    @GetMapping("/admin/deleted")
    public String deletedBoard(){
        return "admin/deletedBoards";
    }

    @GetMapping("/admin/boards")
    public String manageBoards(){
        return "admin/manageBoards";
    }

    @GetMapping("/admin/comments")
    public String manageComments(){return "admin/manageComments";}

    @GetMapping("/admin/users")
    public String manageUsers(){
        return "admin/manageUsers";
    }

    @GetMapping("/admin/files")
    public String manageFiles(){
        return "admin/manageFiles";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "user/mypage";
    }

    @GetMapping("/newboard")
    public String newboard(@RequestParam(required = false) Long bno, Model model){

        model.addAttribute("board", new BoardViewDto());

        return "newboard";
    }

    @GetMapping("/modifyboard")
    public String modifyboard(){
        return "modifyboard";
    }

    @GetMapping("/viewboard/{bno}")
    public String viewBoard(@PathVariable Long bno, Model model) {

        Board board = boardservice.findByBno(bno);
        System.out.println(board.getTitle());
        System.out.println(board.getNickname());

        String hashtags = board.getHashtag();
        List<String> hashtagList = Arrays.asList(hashtags.split("#"));
        // 빈 문자열을 제외합니다.
        hashtagList = hashtagList.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        model.addAttribute("hashtags", hashtagList);

        model.addAttribute("board", board);
        return "viewBoard";
    }
}
