package com.hillel.homework_25.dao;

import com.hillel.homework_25.models.StudentsClass;
import com.hillel.homework_25.utils.HibernateSessionFactoryUtilClass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoClass {
    public StudentsClass findById(int id) {
        return (StudentsClass) HibernateSessionFactoryUtilClass
                .getSessionFactory().
                        openSession().
                        get(StudentsClass.class, id);
    }

    public List<StudentsClass> findByName(String name) {
        Session session = HibernateSessionFactoryUtilClass.
                getSessionFactory().
                openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("From StudentsClass where fullName =  '" + name + "'");
        List<StudentsClass> stName = query.list();
        tx1.commit();
        session.close();
        return stName;
    }

    public void save(StudentsClass student) {
        Session session = HibernateSessionFactoryUtilClass.
                getSessionFactory().
                openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    public long getStudentsCount() {
        Session session = HibernateSessionFactoryUtilClass.
                getSessionFactory().
                openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("SELECT COUNT(id) AS totalRows FROM StudentsClass id");
        long result = (long) query.uniqueResult();
        tx1.commit();
        session.close();

        return result;
    }

    public void printStudents() {
        Session session = HibernateSessionFactoryUtilClass
                .getSessionFactory()
                .openSession();
        Transaction tx1 = session.beginTransaction();
        List<StudentsClass> list = session.createQuery("From StudentsClass").list();
        for (StudentsClass test : list) {
            System.out.println("\n---------------------------------------" +
                    "\n" + test.getFullName() +
                    "\n" + test.getGroup() +
                    "\n" + test.getAdmYear() + " - [Year of Admission]" +
                    "\n" + test.getId() + " - [Student ID]" +
                    "\n---------------------------------------");
        }
        tx1.commit();
        session.close();
    }
}
