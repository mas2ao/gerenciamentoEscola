package com.persist;

import com.hibernate.HibernateUtil;
import org.hibernate.*;

public class EntityPersist {
    private Session session;
    private Transaction tx;
    private String retValue;
    
    private void init() {
        session = HibernateUtil.getSession();
        retValue = "success";
        tx = null;
    }
    
    public String save(Object obj) {
        init();
        try {
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
            e.printStackTrace();
            retValue = "failed";
        } finally {
            session.close();
        }
        return retValue;
    }
}
