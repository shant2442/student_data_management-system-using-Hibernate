package com.hibernateProject.Project.Utils;

import com.hibernateProject.Project.Entities.cetificates;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import java.lang.module.Configuration;


public class HibernateUtils {

    private static SessionFactory sessionFactory;

    static {
        try{

            if(sessionFactory == null){
               sessionFactory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(cetificates.class).buildSessionFactory();
            }

        }
        catch(Exception e)
        {
            throw new RuntimeException("Error is creating session factory " + e.getMessage());

        }
    }

    public static SessionFactory getSession(){
        return sessionFactory;

    }
}
