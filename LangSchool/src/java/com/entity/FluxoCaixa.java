
package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fluxocaixa")
public class FluxoCaixa {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "valor")
    private float valor;
    
    @Column(name = "data_movimento")
    private String data;

    public int getId() {
        return id;
    }

    public void setCodFluxo(int id) {
        this.id = id;
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
