/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rod
 */
@Entity
@Table(name = "FLUXOCAIXA")
public class FluxoCaixa {
    @Id@GeneratedValue
    @Column(name = "codfluxo") private int codFluxo;
    @Column(name = "descricao") private String descricao;
    @Column(name = "valor") private float valor;
    @Column(name = "dataMovimento") private String data;

    public int getCodFluxo() {
        return codFluxo;
    }

    public void setCodFluxo(int codFluxo) {
        this.codFluxo = codFluxo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
