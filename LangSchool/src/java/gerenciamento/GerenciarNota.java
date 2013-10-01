/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import com.entity.Matricula;
import com.persist.EntityPersist;

/**
 *
 * @author massao
 */
public class GerenciarNota {
    
    private int id;
    private int nota1;
    private int nota2;
    private int nota3;
    private int nota4;
    private EntityPersist ep = new EntityPersist();
    
    public void seId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    
    public void setNota1(int nota1){
        this.nota1 = nota1;
    }
    public int getNota1(){
        return nota1;
    }
    
    public void setNota2(int nota2){
        this.nota2 = nota2;
    }
    public int getNota2(){
        return nota2;
    }
    
    public void setNota3(int nota3){
        this.nota3 = nota3;
    }
    public int getNota3(){
        return nota3;
    }
    
    public void setNota4(int nota4){
        this.nota4 = nota4;
    }
    public int getNota4(){
        return nota4;
    }
    
    public void alterarNota(Matricula aluno, int av){
        
    }
    
    public int calcMedia(Matricula aluno){
        int media;
        
        media = Math.round((aluno.notas.nota1)+(aluno.notas.nota2)+(aluno.notas.nota3)+(aluno.notas.nota4))/4));
        return media;
    }

    
    
}
