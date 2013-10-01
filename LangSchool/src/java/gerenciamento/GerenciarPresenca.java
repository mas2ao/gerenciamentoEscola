/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import com.entity.Matricula;

/**
 *
 * @author massao
 */
public class GerenciarPresenca {
    
    private int id;
    private String data;
    private Matricula matricula;
    
    public int getId(){
        return id;
    }
    
    public String getData(){
        return data;
    }
    
    public Matricula getMatricula(){
        return matricula;
    }
    
}
