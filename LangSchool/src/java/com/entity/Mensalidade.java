/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author massao
 */
@Entity
@Table(name = "mensalidade")
public class Mensalidade implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "valor")
    private float valorMensalidade;
    
    @Column(name = "situacao")
    private boolean situMensalidade;
    
    @Column(name = "mes")
    private String mes;
    
    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;
    
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
    
}