package com.DAO;

import com.entity.ReposicaoAula;

public class ReposicaoAulaDAO extends DAO {

    private ReposicaoAula repAula;

    @Override
    public String incluir(Object obj) {
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
        repAula = (ReposicaoAula) obj;
        try {
            ep.delete(repAula);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @Override
    public String alterar(Object obj) {
        repAula = (ReposicaoAula) obj;
        try {
            ep.update(repAula);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
