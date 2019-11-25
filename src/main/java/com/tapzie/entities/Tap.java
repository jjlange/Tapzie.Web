package com.tapzie.entities;


import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Table("taps")
public class Tap implements Serializable {

    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    private String content;

    private UUID userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    private Date createdDate;

    public Tap() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String Content) {
        content = Content;
    }

    public void setUserID(UUID uID) {
        userId = uID;
    }

    public UUID getUserID() { return userId; }

    public void setCreatedDate(Date date) {
        createdDate = date;
    }

    public Date getCreatedDate(){ return createdDate; }
}
