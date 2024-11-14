package com.example.demo.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id는 자동 생성
    private Long id;

    private String title;
    private String writer;
    private String contents;

    private LocalDateTime cdate; // 생성일
    private LocalDateTime mdate; // 수정일

    // 기본 생성자
    public Blog() {}

    // 생성자 (타이틀, 작가, 내용, 생성일, 수정일)
    public Blog(String title, String writer, String contents, LocalDateTime cdate, LocalDateTime mdate) {
        this.title = title;
        this.writer = writer;
        this.contents = contents;
        this.cdate = cdate;
        this.mdate = mdate;
    }

    // Getter 및 Setter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getCdate() {
        return cdate;
    }

    public void setCdate(LocalDateTime cdate) {
        this.cdate = cdate;
    }

    public LocalDateTime getMdate() {
        return mdate;
    }

    public void setMdate(LocalDateTime mdate) {
        this.mdate = mdate;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", contents='" + contents + '\'' +
                ", cdate=" + cdate +
                ", mdate=" + mdate +
                '}';
    }
}
