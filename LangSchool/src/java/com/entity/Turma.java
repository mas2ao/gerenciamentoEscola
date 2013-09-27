/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.persistence.*;

/**
 *
 * @author john
 */
@Entity
@Table(name = "Turma")
public class Turma {
    @Id @GeneratedValue
    @Column (name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;
    
    @ManyToOne
    @JoinColumn(name = "id_nivel")
    private Nivel nivel;
    
    @Column (name = "codigo")
    private int codigo;
    
    @Column (name = "turma")
    private String turma;
    
    @Column (name = "descricao")
    private String descricao;
    
    @Column (name = "vagas")
    private int vagas;
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNivel(Nivel nivel){
        this.nivel = nivel;
    }
    
    public Nivel getNivel(){
        return this.nivel;
    }
    
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    
    public Professor getProfessor(){
        return this.professor;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setTurma(String turma){
        this.turma = turma;
    }
    
    public String getTurma(){
        return this.turma;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setVagas(int vagas){
        this.vagas = vagas;
    }
    
    public int getVagas(){
        return this.vagas;
    }    
}
