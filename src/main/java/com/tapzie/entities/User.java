package com.tapzie.entities;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Justin Lange on 1/10/17.
 */
@Entity()
@Table(name="users")
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="username")
    private String username;

    @Column(name="authkey")
    private String authkey;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="profilePicture")
    private String profilePicture;

    @Column(name="profileBackgroundPicture")
    private String profileBackgroundPicture;

    @Column(name="status")
    private Integer status;

    @Column(name="verified")
    private boolean verified;


    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthKey() {
        return authkey;
    }

    public void setAuthKey(String authkey) {
        this.authkey = authkey;
    }

    public String getFirstName() { return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getProfileBackgroundPicture() {
        return profileBackgroundPicture;
    }

    public void setProfileBackgroundPicture(String profileBackgroundPicture) {
        this.profileBackgroundPicture = profileBackgroundPicture;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
