package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ReposicaoAula")
public class ReposicaoAula implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date dataReposicao;
    
    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;
    
    @OneToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;
    
    @Column(name = "estado")
    private String estado;

    public int getId() {
        return id;
    }

    public Date getDataReposicao() {
        return dataReposicao;
    }

    public void setDataReposicao(Date dataReposicao) {
        this.dataReposicao = dataReposicao;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void alteraEstado() {
        if(this.estado.equals("inativo")) this.estado = "ativo";
        this.estado = "inativo";
    }
}
