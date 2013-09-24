package com.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
        
@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;
    
    @OneToOne
    @JoinColumn(name = "id_nota")
    private Nota notas;
    
    @Column
    private String dataMatricula;
    
    @OneToMany(mappedBy = "matricula")
    private Set<Presenca> presenca;
    
    @OneToMany(mappedBy = "matricula")
    private Set<Mensalidade> mensalidade;
    
    @OneToMany(mappedBy = "matricula")
    private Set<ReposicaoAula> reposicoes;

    public int getId() {
        return id;
    }

    public Nota getNotas() {
        return notas;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
}
