package com.persist;

import com.hibernate.HibernateUtil;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private Method createMethod(String meth, Class<?>... types) {
        Method method = null;
        try {
            method = EntityPersist.class.getMethod(meth, types);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(EntityPersist.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(EntityPersist.class.getName()).log(Level.SEVERE, null, ex);
        }
        return method;
    }

    private String doSerialize(Object obj, Method method) throws Exception {
        init();
        try {
            tx = session.beginTransaction();
            method.invoke(EntityPersist.class, obj);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            retValue = "failed";
        } finally {
            session.close();
        }
        return retValue;
    }

    private void saveFunction(Object obj) {
        session.save(obj);
    }

    public String save(Object obj) throws Exception {
        return doSerialize(obj, createMethod("saveFunction", obj.getClass()));
    }
}
