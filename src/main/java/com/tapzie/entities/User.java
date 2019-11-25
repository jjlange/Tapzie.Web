package com.tapzie.entities;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Justin Lange on 1/10/17.
 */
@Table("users")
public class User implements Serializable{

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Indexed
    private String email;

    @Indexed
    private String password;
    private String username;

    @Indexed
    private String authkey;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String profileBackgroundPicture;
    private Integer status;
    private boolean verified;


    public UUID getId() { return id; }

    public void setId(UUID id) {
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
