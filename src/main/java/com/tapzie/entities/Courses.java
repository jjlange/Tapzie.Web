package com.tapzie.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="courses")
public class Courses implements Serializable {


    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="course_name")
    private String course_name;

    @Column(name="course_created_by")
    private String course_created_by;

    @Column(name="course_language")
    private String course_language;

    @Column(name="course_learning_language")
    private String course_learning_language;

    @Column(name="course_created_date")
    private String course_created_date;


    private Long getID() {
        return id;
    }

    private void setID() {
        this.id = id;
    }

    private String getCourseName() {
        return course_name;
    }

    private void setCourseName() {
        this.course_name = course_name;
    }

    private String getCourseCreatedBy() {
        return course_created_by;
    }

    private void setCourseCreatedBy() {
        this.course_created_by = course_created_by;
    }

    private String getCourseLanguage() {
        return course_language;
    }

    private void setCourseLanguage() {
        this.course_language = course_language;
    }

    private String getCourseLearningLanguage() {
        return course_learning_language;
    }

    private void setCourseLearningLanguage() {
        this.course_learning_language = course_learning_language;
    }

    private String getCourseCreatedDate() {
        return course_created_date;
    }

    private void setCourseCreatedDate() {
        this.course_created_date = course_created_date;
    }
}
