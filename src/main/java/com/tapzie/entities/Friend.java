package com.tapzie.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="friends")
public class Friend implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="userId")
    private Long userId;

    @Column(name="friendId")
    private Long friendId;

    @Column(name="status")
    private boolean status;


    public Friend() {
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

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
