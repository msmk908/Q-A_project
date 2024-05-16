package com.codeqna.service;

import com.codeqna.dto.AddBoardRequest;
import com.codeqna.dto.BoardViewDto;
import com.codeqna.entity.Board;
import com.codeqna.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    //게시물 상세 페이지 가져오기
    public Board findByBno(Long bno) {
        return boardRepository.findByBno(bno);
    }

    public Board save(AddBoardRequest request){
        return boardRepository.save(request.toEntity());
    }

}

