package com.hibernateProject.Project.Entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table ( name="students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long StudentID;


    @Column(name="student_name",length=100,unique=true)
    private String name;

    @Column(name = "student_college",length=200,nullable=true)
    private String Collegename;
    private String phone;
    private String fathername;
    private Boolean active=true;

    @OneToMany (mappedBy = "student",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<cetificates> certificate=new ArrayList<cetificates>();

    public List<cetificates> getCertificate() {
        return certificate;
    }

    public void setCertificate(List<cetificates> certificate) {
        this.certificate = certificate;
    }

    @Lob
    private String about;

    public long getStudentID() {
        return StudentID;
    }

    public void setStudentID(long studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegename() {
        return Collegename;
    }

    public void setCollegename(String collegename) {
        Collegename = collegename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
