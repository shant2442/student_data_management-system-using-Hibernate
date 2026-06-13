package com.hibernateProject.Project;

import com.hibernateProject.Project.Entities.Students;
import com.hibernateProject.Project.Entities.cetificates;
import com.hibernateProject.Project.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class mainApp {

    public static void main(String[] args) {

        System.out.println("hello world");
//        System.out.println(factory);

        // creating student

        Students student=new Students();
        student.setName("neha");
        student.setCollegename("techniacal");
        student.setPhone("8348242434");
        student.setAbout("this is dummy data");
        student.setActive(true);
        student.setFathername("kappu");

        cetificates cet=new cetificates();
        cet.setTitle("java");
        cet.setLink("link");
//        cet.setTitle();
        cet.setAbout("certifiacte for java");
        cet.setStudent(student);


        student.getCertificate().add(cet);
        SessionFactory factory = (SessionFactory) HibernateUtils.getSession();
        Session session = factory.openSession();
        Transaction transaction = null;
        try{
            transaction=session.beginTransaction();
            session.persist(student);
            transaction.commit();
            System.out.println("student save successfullyy -----> ");
        }
        catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }


    }
}
