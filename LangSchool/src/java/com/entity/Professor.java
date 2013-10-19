
package com.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Professor")
public class Professor implements Serializable {
    @Id 
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "estado")
    private String estado;
    
    public Professor(){
        this.estado = "ativo";
    }

    public Professor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.estado = "ativo";
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
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Professor))
            return false;
        return (((Professor)o).getNome().equals(this.nome));
    }
}