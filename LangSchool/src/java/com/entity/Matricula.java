/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author yukill
 */
@Entity
@Table(name = "matricula")
public class Matricula {
    @Id
    private int id;
    @Column(name = "nome")
    public String aluno;
    @ManyToOne //Esqueci as opções que vao dentro dos ()... Tem que pesquisar...
    //Também tem @ManyToMany... @ManyToAny... @OneToMany...
    public ArrayList<Integer> notas;
}
