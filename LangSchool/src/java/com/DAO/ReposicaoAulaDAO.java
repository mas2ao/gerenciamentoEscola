package com.DAO;

import com.entity.ReposicaoAula;

public class ReposicaoAulaDAO extends DAO{

    @Override
    public String incluir(Object obj) {
        ReposicaoAula repAula;
        repAula = (ReposicaoAula) obj;
        try {
            ep.save(repAula);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @Override
    public String excluir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
