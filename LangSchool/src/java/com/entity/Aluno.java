package com.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
    
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "aluno")
    private Set<Matricula> matricula;

    public Set<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(Set<Matricula> matricula) {
        this.matricula = matricula;
    }
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "data_nasc")
    private String dataNasc;
    
    @Column(name = "idade")
    private int idade;
    
    @Column(name = "rg")
    private int rg;
    
    @Column(name = "nome_pai")
    private String nomePai;
    
    @Column(name = "nome_mae")
    private String nomeMae;
    
    @Column(name = "telefone")
    private int telefone;
    
    @Column(name = "complemento")
    private String complemento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}