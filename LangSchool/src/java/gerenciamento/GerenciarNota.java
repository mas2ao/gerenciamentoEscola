/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import com.entity.Aluno;
import com.entity.Matricula;
import com.entity.Nota;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 *
 * @author massao
 */
@ManagedBean
public class GerenciarNota {

    private Nota nota = new Nota();
    private String estado, busca, param;
    private Matricula selecionado;
    private List<Aluno> alunos;
    private EntityPersist ep = new EntityPersist();

    public Nota getNota(){
        return nota;
    }
    public void setNota(Nota nota){
        this.nota = nota;
    }
    
    public String getBusca(){
        return busca;
    }
    public void setBusca(String busca){
        this.busca = busca;
    }
    
    public String getParam(){
        return param;
    }
    public void setParam(String param){
        this.param = param;
    }

    public Matricula getSelecionado(){
        return selecionado;
    }
    public void setSelecionado(Matricula selecionado){
        this.selecionado = selecionado;
    }
    
    public void escolherAluno(ActionEvent ae) {
        this.selecionado = (Matricula)ae.getComponent().getAttributes().get("matricula");
        System.out.println(selecionado.getMatricula());
    }
    
    public void consultarAluno(ActionEvent ae) {
        if (busca.trim().equals(""))
            this.alunos = ep.search(Aluno.class);
        else
            this.alunos = ep.search(Aluno.class, new CriteriaGroup("eq", param, busca, null));
    }
    
    public void adicionarNotas(){
        nota.setNota1(0);
        nota.setNota2(0);
        nota.setNota3(0);
        nota.setNota4(0);
        try {
            ep.save(nota);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void alterarNota(){
        try {
            ep.update(nota);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void excluirNota(Matricula aluno){
        aluno.alteraEstado();
    }
    
    public int calcularMedia(Matricula aluno){
        int media;
        
        media = Math.round((nota.getNota1())+(nota.getNota2())+(nota.getNota3())+(nota.getNota4()))/4;
        return media;
    }
    
}
