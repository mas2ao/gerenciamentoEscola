package com.entity;

import com.hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.Session;
        
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

    public Matricula() {}
    
    public Matricula(Aluno aluno, Turma turma, Date dataMatricula) {
        this.aluno = aluno;
        this.turma = turma;
        this.dataMatricula = dataMatricula;
    }    
    
    public int getId() {
        return id;
    }

    public Nota getNotas() {
        return notas;
    }
    
    public void setNotas(Nota nota) {
        this.notas = nota;
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

    public void setPresenca(Set<Presenca> presenca) {
        this.presenca = presenca;
    }
    
    
    public Set<Presenca> getPresenca() {
        return this.presenca;
    }
    
    public ArrayList<Presenca> getPresencaList(){
        return new ArrayList<Presenca>(presenca);
    }
    
    
}
