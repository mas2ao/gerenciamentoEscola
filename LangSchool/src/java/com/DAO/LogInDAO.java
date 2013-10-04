package com.DAO;

import com.entity.LogIn;

public class LogInDAO extends DAO {
    private LogIn login;
    
    @Override
    public String incluir(Object obj) {
        login = (LogIn) obj;
        try {
            ep.save(login);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @Override
    public String excluir(Object obj) {
        login = (LogIn) obj;
        try {
            ep.delete(login);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @Override
    public String alterar(Object obj) {
        login = (LogIn) obj;
        try {
            ep.update(login);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "success";
    }
    
}
