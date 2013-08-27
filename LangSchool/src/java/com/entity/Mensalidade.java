/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author yukill
 */
@Entity
@Table(name = "Mensalidade")
public class Mensalidade {

    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "Valor")
    private float valorMensalidade;
    @Column(name = "Situacao")
    private boolean situMensalidade;
    @Column(name = "Mes")
    @Temporal(javax.persistence.TemporalType.DATE)
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
