package com.hibernateProject.Project;

import com.hibernateProject.Project.Entities.Students;
import com.hibernateProject.Project.services.studentservice;
import org.junit.jupiter.api.Test;



public class appTest {
    @Test
    public void Test(){
        studentservice ss= new studentservice();

        Students student=ss.getstudent(9);
//        System.out.println("jkhfweh8rrewbfuwehfih84hrfheifeh8hh84hihferh88hr8hehhgerhufihhirh");
        System.out.println(student.getName());
        System.out.println(student.getCertificate().size());
       student.getCertificate().forEach(cer-> {
           System.out.println(cer.getTitle());
       });


    }


}
