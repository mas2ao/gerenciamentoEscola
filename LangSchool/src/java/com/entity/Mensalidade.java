/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;

/**
 *
 * @author yukill
 */
public class Mensalidade {

    private int id;
    private float valorMensalidade;
    private boolean situMensalidade;
    private Date mes;
    
    public int getId(){
        return id;
    }
    public float getValorMensalidade(){
        return valorMensalidade;
    }
    
    public boolean getSituMensalidade(){
        return situMensalidade;
    }
    
    public void setSituMensalidade(boolean situMensalidade) {
        this.situMensalidade = situMensalidade;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }
    
    
}
