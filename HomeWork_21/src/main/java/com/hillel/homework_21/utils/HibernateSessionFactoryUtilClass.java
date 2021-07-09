package com.hillel.homework_21.utils;

import com.hillel.homework_21.models.StudentsClass;
import com.hillel.homework_21.models.StudyGroupClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtilClass {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtilClass() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(StudentsClass.class);
                configuration.addAnnotatedClass(StudyGroupClass.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}