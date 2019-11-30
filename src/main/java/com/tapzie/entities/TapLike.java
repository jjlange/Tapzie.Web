package com.tapzie.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="taps_likes")
public class TapLike implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="userId")
    private Long userId;

    @Column(name="tapId")
    private Long tapId;


    public TapLike() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTapId() {
        return tapId;
    }

    public void setTapId(Long tapId) {
        this.tapId = tapId;
    }
}
