/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author massao
 */
@Entity
@Table(name = "Presenca")
public class Presenca implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "dia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dia;
    
    @Column(name = "presente/ausente")
    private int presAus;
    
    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;
    
    @Column(name = "estado")
    private String estado;
    
    public int getId(){
        return id;
    }
    
    public Date getDia(){
        return dia;
    }
    
    public void setDia(Date dia){
        this.dia = dia;
    }
    
    public int getPresAus(){
        return presAus;
    }
    
    public void alteraEstado(String estado){
        if (this.estado.equals("inativo")) this.estado = "ativo";
        this.estado = "inativo";
    }
    
    public String getEstado(){
        return estado;
    }
    
}
