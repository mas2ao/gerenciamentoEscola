package com.DAO;

import com.entity.Matricula;
import com.persist.EntityPersist;

public class MatriculaDAO {
    private EntityPersist ep;
    
    public String matricular(Matricula mat) {
        try {
            ep.save(mat);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
    
    public String removerMatricula(Matricula mat) {
        try {
            mat.alteraEstado();
            ep.update(mat);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
