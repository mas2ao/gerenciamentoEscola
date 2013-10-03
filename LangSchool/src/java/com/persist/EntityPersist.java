package com.persist;

import com.hibernate.HibernateUtil;
import com.util.CriteriaGroup;
import java.lang.reflect.Method;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class EntityPersist {

    private Session session;
    private Transaction tx;
    private String retValue;

    //Inicializa
    private void init() {
        session = HibernateUtil.getSession();
        retValue = "success";
        tx = null;
    }
    
    //Cria um tipo metodo da funcao "meth"
    private Method createMethod(String meth, Class<?>... types) {
        Method method = null;
        try {
            method = EntityPersist.class.getMethod(meth, types);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
        return method;
    }

    //Funcao generica
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

    //Para salvar
    private void saveFunction(Object obj) {
        session.save(obj);
    }

    public String save(Object obj) throws Exception {
        return doSerialize(obj, createMethod("saveFunction", obj.getClass()));
    }
    
    //Para deletar
    private void delFunction(Object obj) {
        session.delete(obj);
    }
    
    public String delete(Object obj) throws Exception {
        return doSerialize(obj, createMethod("delFunction", obj.getClass()));
    }
    
    //Para fazer update
    private void updateFunction(Object obj) {
        session.update(obj);
    }
    
    public String update(Object obj) throws Exception {
        return doSerialize(obj, createMethod("updateFunction", obj.getClass()));
    }
    
    public List search(Class cName, CriteriaGroup... addCrit) {
        init();
        List crit;
        Criteria criteria = session.createCriteria(cName);
        for(CriteriaGroup cg : addCrit) {
            criteria.add(createRestriction(cg));
        }
        crit = criteria.list();
        session.close();
        return crit;
    }

    private Criterion createRestriction(CriteriaGroup cg) {
        if(cg.type.equals("like")) return Restrictions.like(cg.attribute, cg.valueFrom);
        if(cg.type.equals("eq")) return Restrictions.eq(cg.attribute, cg.valueFrom);
        if(cg.type.equals("lt")) return Restrictions.lt(cg.attribute, cg.valueFrom);
        if(cg.type.equals("gt")) return Restrictions.gt(cg.attribute, cg.valueFrom);
        if(cg.type.equals("ge")) return Restrictions.ge(cg.attribute, cg.valueFrom);
        if(cg.type.equals("le")) return Restrictions.le(cg.attribute, cg.valueFrom);
        if(cg.type.equals("between")) return Restrictions.between(cg.attribute, cg.valueFrom, cg.valueTo);
        if(cg.type.equals("sql")) return Restrictions.sqlRestriction(cg.attribute);
        return null;
    }
}
