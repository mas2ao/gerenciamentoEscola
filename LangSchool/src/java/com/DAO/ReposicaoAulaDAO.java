package com.DAO;

import com.entity.ReposicaoAula;
import com.persist.EntityPersist;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReposicaoAulaDAO {
    private EntityPersist ep;
    
    public String incluirReposicao(ReposicaoAula repAula) {
        try {
            ep.save(repAula);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
