package com.hibernateProject.Project.services;

import com.hibernateProject.Project.Entities.Students;
import com.hibernateProject.Project.Utils.HibernateUtils;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;


import java.util.List;


public class studentservice {

    private SessionFactory sessionfactory= (SessionFactory) HibernateUtils.getSession();

                                    // save the student



    public void savestudent(Students student){

        try(Session session=  sessionfactory.openSession())
        {
            Transaction transaction=session.beginTransaction();
            session.persist(student);
            transaction.commit();

        }
        catch(Exception e)
        {
            System.out.println("error occuesd plese handle it ..");
            e.printStackTrace();
        }


    }

                                  // get  by Studentid

    public Students getstudent(long id){
        try(Session session= sessionfactory.openSession())
        {
           Students student= session.get(Students.class, id);
           return student;


        }
        catch(Exception e)
        {
            System.out.println("error occuesd plese handle it ..");
            e.printStackTrace();
            return null;
        }
//        return student;
    }

                                // update student

    public Students updatestudent(long studentId,Students student){

        try(Session session= sessionfactory.openSession())
        {
            Transaction transaction=session.beginTransaction();
            Students oldStudent= session.get(Students.class, studentId);
           if(oldStudent!=null){
               oldStudent.setName(student.getName());
               oldStudent.setFathername(student.getFathername());
               oldStudent.setPhone(student.getPhone());
               oldStudent=session.merge(oldStudent);
               session.update(oldStudent );
               transaction.commit();

           }
           return oldStudent;
        }
        catch(Exception e)
        {
            System.out.println("error occuesd plese handle it ..");
            return null;
        }

    }


                             // delete student


    public void deletestudent(long studentId){
        try(Session session= sessionfactory.openSession())
        {
            Transaction transaction=session.beginTransaction();
            session.get(Students.class, studentId);
            Students student= session.get(Students.class, studentId);
            if(session!=null)
            {
                session.delete(student);
                transaction.commit();
            }
        }
    }


                            // HQL ---> NATIVE LANGUAGE
                             // database independent

    public List<Students> getAllstudentsHQL(){

        try(Session session= sessionfactory.openSession())

        {
            String hql="from Students";
            Query<Students> query=session.createQuery(hql,Students.class);
            return query.getResultList();

        }

    }

                    //get student by name

    public Students getstudnetBynameHQL(String name)
    {
        try(Session session= sessionfactory.openSession())
        {
            String hql="from Students where name=:name";
            Query<Students> query=session.createQuery(hql,Students.class);
            query.setParameter("name",name);
            return query.uniqueResult();

        }
    }

                        //criteria api
                        // get all  students of same college

    public List<Students> getallstudentsByCollege(String college)
    {
        try(Session session= sessionfactory.openSession())
        {
            HibernateCriteriaBuilder criterriabuilder=session.getCriteriaBuilder();
            CriteriaQuery<Students> cq=session.getCriteriaBuilder().createQuery(Students.class);
            Root<Students> root=cq.from(Students.class);
            cq.select(root).where(criterriabuilder.equal(root.get("college"),"college"));
            Query<Students> query=session.createQuery(cq);
            return query.getResultList();
        }
    }
}
