package com.hibernateProject.Project.Entities;

import jakarta.persistence.*;

@Entity
@Table ( name="student_certificate")
public class cetificates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificateID;

    private String title;

    public long getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(long certificateID) {
        this.certificateID = certificateID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String about;
    private String link;

    @ManyToOne
    @JoinColumn(name="studentId")
    private Students student;


}
