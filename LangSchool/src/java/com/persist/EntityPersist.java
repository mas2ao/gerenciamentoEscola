package com.persist;

import com.entity.*;
import com.hibernate.HibernateUtil;
import java.lang.reflect.Method;
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
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
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
    
    private void delFunction(Object obj) {
        session.delete(obj);
    }
    
    public String delete(Object obj) throws Exception {
        return doSerialize(obj, createMethod("delFunction", obj.getClass()));
    }
    
    private void updateFunction(Object obj) {
        if(obj instanceof Aluno) obj = (Aluno) session.merge(obj);
        if(obj instanceof Curso) obj = (Curso) session.merge(obj);
        if(obj instanceof FluxoCaixa) obj = (FluxoCaixa) session.merge(obj);
        if(obj instanceof LogIn) obj = (LogIn) session.merge(obj);
        if(obj instanceof Matricula) obj = (Matricula) session.merge(obj);
        if(obj instanceof Mensalidade) obj = (Mensalidade) session.merge(obj);
        if(obj instanceof Nivel) obj = (Nivel) session.merge(obj);
        if(obj instanceof Nota) obj = (Nota) session.merge(obj);
        if(obj instanceof Presenca) obj = (Presenca) session.merge(obj);
        if(obj instanceof Professor) obj = (Professor) session.merge(obj);
        if(obj instanceof ReposicaoAula) obj = (ReposicaoAula) session.merge(obj);
        if(obj instanceof Turma) obj = (Turma) session.merge(obj);
        session.update(obj);
    }
    
    public String update(Object obj) throws Exception {
        return doSerialize(obj, createMethod("updateFunction", obj.getClass()));
    }
}
