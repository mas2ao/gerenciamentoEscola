package com.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ReposicaoAula")
public class ReposicaoAula implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    @Column
    private String dataReposicao;
    
    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;
    
    @OneToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    public int getId() {
        return id;
    }

    public String getDataReposicao() {
        return dataReposicao;
    }

    public void setDataReposicao(String dataReposicao) {
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
    
}
