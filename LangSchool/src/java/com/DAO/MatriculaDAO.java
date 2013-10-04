package com.DAO;

import com.entity.Matricula;

public class MatriculaDAO extends DAO{
    private Matricula matricula;
    
    @Override
    public String incluir(Object obj) {
        matricula = (Matricula) obj;
        try {
            ep.save(matricula);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @Override
    public String excluir(Object obj) {
        matricula = (Matricula) obj;
        try {
            matricula.alteraEstado();
            ep.update(matricula);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @Override
    public String alterar(Object obj) {
        matricula = (Matricula) obj;
        try {
            ep.update(matricula);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
