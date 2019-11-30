package com.tapzie.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="taps")
public class Tap implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Lob
    @Column(name="content")
    private String content;

    @Column(name="userId")
    private Long userId;

    @Column(name="createdDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private User creator;

    @Column(name="likes")
    private Long likes;

    public Tap() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String Content) {
        content = Content;
    }

    public void setUserID(Long uID) {
        userId = uID;
    }

    public Long getUserID() { return userId; }

    public void setCreatedDate(Date date) {
        createdDate = date;
    }

    public Date getCreatedDate(){ return createdDate; }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }
}
