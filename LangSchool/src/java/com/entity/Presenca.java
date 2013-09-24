/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author massao
 */
@Entity
@Table(name = "presenca")
public class Presenca implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "data")
    private String data;
    
    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;
    
    public int getId(){
        return id;
}
    public String getData(){
        return data;
    }
    
}
