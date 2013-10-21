/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import com.entity.Aluno;
import com.entity.Matricula;
import com.entity.Presenca;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 *
 * @author massao
 */

@ManagedBean
public class GerenciarPresenca {
    
    private Presenca presenca = new Presenca();
    private String estado, busca, param;
    private Matricula selecionado;
    private List<Aluno> alunos;
    private EntityPersist ep = new EntityPersist();

    public Presenca getPresenca(){
        return presenca;
    }
    public void setPresenca(Presenca presenca){
        this.presenca = presenca;
    }

    public String getBusca() {
        return busca;
    }
    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getParam() {
        return param;
    }
    public void setParam(String param) {
        this.param = param;
    }

    public Matricula getSelecionado() {
        return selecionado;
    }
    public void setSelecionado(Matricula selecionado) {
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
    
    public void adicionarPresenca(){
        Presenca pres = new Presenca();
        Date dt = new Date();
        pres.setDia(dt);
    }
    
    public void marcarPresAus(){
        
    }
    
    public void excluirPresenca(Matricula aluno){
        aluno.alteraEstado();
    }
    
}
