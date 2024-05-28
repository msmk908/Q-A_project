package com.codeqna.dto;

import com.codeqna.entity.Board;
import com.codeqna.entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardSearchDto {

    private Long bno;

    private String title;

    private String content;

    private String hashtag;


    private Long hitcount;


    private Long heart;

    private LocalDateTime regdate;

    private String nickname;


    private String board_condition;

    private Long adoptedReply;

    public BoardSearchDto(Board board,String nickname) {
        this.bno = board.getBno();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.hashtag = board.getHashtag();
        this.hitcount = board.getHitcount();
        this.heart = board.getHeart();
        this.regdate = board.getRegdate();
        this.nickname = nickname;
        this.board_condition = board.getBoard_condition();
        this.adoptedReply = board.getAdoptedReply();
    }
}
