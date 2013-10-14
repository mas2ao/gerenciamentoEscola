package gerenciamento;

import com.entity.Aluno;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import messages.Gmessages;

@ViewScoped
@ManagedBean
public class GerenciarAluno {
    private Aluno aluno = new Aluno();
    private Aluno selecionado;
    private List<Aluno> alunos;
    private EntityPersist ep = new EntityPersist();
    private String busca = new String();
    private String param = new String();
    private Gmessages msg = new Gmessages();
    
    public GerenciarAluno() {
        System.out.println("Ativado");
        alunos = ep.search(Aluno.class);
        selecionado = new Aluno();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
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

    public Aluno getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Aluno selecionado) {
        this.selecionado = selecionado;
    }
    
    public void cadastrarAluno(ActionEvent ae) {
        try {
            ep.save(aluno);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removerAluno(ActionEvent ae) {
        this.aluno.setEstadoInativo();
        try {
            ep.update(aluno);
            msg.remover(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarAluno(ActionEvent ae) {
        System.out.println("AQUIII");
        if(busca.trim().equals("")) 
            this.alunos = ep.search(Aluno.class);
        else
            this.alunos = ep.search(Aluno.class, new CriteriaGroup("eq", param, busca, null));
    }
    
    public void alterarAluno(ActionEvent ae) {
        try {
            ep.update(aluno);
            msg.alterar(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escolherAluno(ActionEvent ae) {
        System.out.println("ESCOLHER");
        this.selecionado = (Aluno) ae.getComponent().getAttributes().get("aluno");
    }
}
