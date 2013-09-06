/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author massao
 */
@Entity
@Table(name = "nota")
public class Nota {
    
    @Id
    @OneToOne
    @JoinColumn(name = "id_nota")
    private int id;
    
    @OneToOne
    @Column(name = "nota_1")
    private int nota1;
    
    @OneToOne
    @Column(name = "nota_2")
    private int nota2;
    
    @OneToOne
    @Column(name = "nota_3")
    private int nota3;
    
    @OneToOne
    @Column(name = "nota_4")
    private int nota4;
    
    
   public int getId(){
       return id;
   }
   
   public int getNota1(){
       return nota1;
   }
   
   public void setNota1(int nota1){
       this.nota1 = nota1;
   }
   
   public int getNota2(){
       return nota2;
   }
   
   public void setNota2(int nota2){
       this.nota2 = nota2;
   }
   
   public int getNota3(){
       return nota3;
   }
   
   public void setNota3(int nota3){
       this.nota3 = nota3;
   }
   
   public int getNota4(){
       return nota4;
   }
   
   public void setNota4(int nota4){
       this.nota4 = nota4;
   }
   
   
}