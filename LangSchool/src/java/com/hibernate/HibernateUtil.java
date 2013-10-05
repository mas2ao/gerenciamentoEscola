package com.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    private static final SessionFactory sesFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        SessionFactory fact = null;
        try {
           fact = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return fact;
    }
    
    protected static Session getSession() {
        return sesFactory.openSession();
    }
}
