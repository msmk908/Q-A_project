package com.example.qa_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "board")
public class board {

    @Id
    @GeneratedValue
    @Column(name = "bno", nullable = false)
    private Long bno;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "hashtag")
    private String hashtag;

    @Column(name = "hitcount")
    private String hitcount;

    @Column(name = "likecount")
    private String likecount;

    @Column(name = "regdate")
    private String regdate;

    @Column(name = "board_writer")
    private String board_writer;

    @Column(name = "board_visible")
    private String board_visible;

}
