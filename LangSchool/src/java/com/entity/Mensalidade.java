/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author massao
 */
@Entity
@Table(name = "mensalidade")
public class Mensalidade {

    @Id
    @OneToOne
    @JoinColumn(name = "id_mensalidade")
    private int id;
    
    @OneToOne
    @Column(name = "valor")
    private float valorMensalidade;
    
    @OneToOne
    @Column(name = "situacao")
    private boolean situMensalidade;
    
    @OneToMany
    @Column(name = "mes")
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