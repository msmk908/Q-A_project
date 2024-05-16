package com.codeqna.controller;

import com.codeqna.dto.AddBoardRequest;
import com.codeqna.entity.Board;
import com.codeqna.repository.BoardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BoardApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; // 직렬화, 역직렬화를 위한 클래스

    @Autowired
    private WebApplicationContext context;

    @Autowired
    BoardRepository boardRepository;

    @DisplayName("addBoard: 게시글 추가에 성공한다.")
    @Test
    public void addBoard() throws Exception {
        final String url = "/board/register";
        final String title = "테스트 제목";
        final String content = "테스트 내용";
        final String hashtag = "#해쉬태그1#해쉬태그2";
        final Long heart = 0L;
        final Long hitcount = 0L;
        final String nickname = "백민규";
        final String board_condition = "N";
        final AddBoardRequest userRequest = new AddBoardRequest(title, content, hashtag, heart, hitcount, nickname, board_condition);

        final String requestBody = objectMapper.writeValueAsString(userRequest);

        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        result.andExpect(status().isCreated());

        List<Board> board = boardRepository.findAll();

        assertThat(board).hasSize(1); // 게시글이 한 개만 저장되었는지 확인
        assertThat(board.get(0).getTitle()).isEqualTo(title);
        assertThat(board.get(0).getContent()).isEqualTo(content);
        assertThat(board.get(0).getHashtag()).isEqualTo(hashtag);
        assertThat(board.get(0).getHeart()).isEqualTo(heart);
        assertThat(board.get(0).getHitcount()).isEqualTo(hitcount);
        assertThat(board.get(0).getNickname()).isEqualTo(nickname);
        assertThat(board.get(0).getBoard_condition()).isEqualTo(board_condition);

    }

}