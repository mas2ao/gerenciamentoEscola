/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author yukill
 */
@Entity
@Table(name = "Presenca")
public class Presenca {
    
    @Id
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Data")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    public int getId(){
        return id;
    }
    public Date getData(){
        return data;
    }
    
}
