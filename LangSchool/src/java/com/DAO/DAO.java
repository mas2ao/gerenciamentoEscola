package com.DAO;

import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.List;

public abstract class DAO {
    protected EntityPersist ep = new EntityPersist();
    
    public abstract String incluir(Object obj);
    public abstract String excluir(Object obj);
    public abstract String alterar(Object obj);
    
    public List consultar(Class cName, CriteriaGroup... addCrit) {
        return ep.search(cName, addCrit);
    }
}
