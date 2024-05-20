package com.codeqna.repository;

import com.codeqna.entity.Board;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> findByHashtagsContainingAndBoard_condition(String[] keywords, String board_condition);
}
