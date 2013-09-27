package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
        
@Entity
@Table(name = "Matricula")
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
    
    @Column(name = "data_matricula")
    @Temporal(TemporalType.DATE)
    private Date dataMatricula;
    
    @OneToMany(mappedBy = "matricula")
    private Set<Presenca> presenca;
    
    @OneToMany(mappedBy = "matricula")
    private Set<Mensalidade> mensalidade;
    
    @OneToMany(mappedBy = "matricula")
    private Set<ReposicaoAula> reposicoes;

    @Column(name = "estado")
    private String estado;
    
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

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void alteraEstado() {
        if(this.estado.equals("inativo")) this.estado = "ativo";
        this.estado = "inativo";
    }
}
