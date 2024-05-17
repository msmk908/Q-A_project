package com.codeqna.controller;

import com.codeqna.dto.AddBoardRequest;
import com.codeqna.entity.Board;
import com.codeqna.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/board/register")
    public ResponseEntity<Board> addBoard(@RequestBody AddBoardRequest request){
        Board savedBoard = boardService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
    }

    @GetMapping("/searchTable")
    public List<Board> searchBoards(@RequestParam("condition") String condition,
                                    @RequestParam("keyword") String keyword) {
        return boardService.searchBoards(condition, keyword);
    }

}
