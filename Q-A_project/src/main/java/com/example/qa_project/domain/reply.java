package com.example.qa_project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reply")
@Getter
@NoArgsConstructor
public class reply {

    @Id
    @GeneratedValue
    @Column(name = "rno", nullable = false)
    private Long rno;

    @Column(name = "bno")
    private Long bno;

    @Column(name = "reply_writer")
    private String reply_writer;

    @Column(name = "content")
    private String content;

    @Column(name = "regdate")
    private String regdate;

    @Column(name = "parent_id")
    private Integer parent_id;

    @Column(name = "reply_visible")
    private String reply_visible;
}
