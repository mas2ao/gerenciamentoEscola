/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author yukill
 */
@Entity
@Table(name = "Nota")
public class Nota {
    
    @Id
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Nota 1")
    private int nota1;
    
    @Column(name = "Nota 2")
    private int nota2;
    
    @Column(name = "Nota 3")
    private int nota3;
    
    @Column(name = "Nota 4")
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
