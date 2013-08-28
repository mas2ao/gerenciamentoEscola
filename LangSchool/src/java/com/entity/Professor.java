/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "Professor")
public class Professor {
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome")
    private String nome;
    
    public Professor(){}
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
}
