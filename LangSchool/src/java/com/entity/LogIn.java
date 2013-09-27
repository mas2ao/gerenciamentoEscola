package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "Login")
public class LogIn {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "password")
    private String password;
    
    @OneToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    public int getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
