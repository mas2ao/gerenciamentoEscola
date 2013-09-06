/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author massao
 */
@Entity
@Table(name = "presenca")
public class Presenca {
    
    @Id
    @OneToOne
    @JoinColumn(name = "id_presenca")
    private int id;
    
    @OneToOne
    @Column(name = "data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    public int getId(){
        return id;
}
    public Date getData(){
        return data;
    }
    
}
