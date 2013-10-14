package gerenciamento;

import com.entity.Aluno;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import messages.Gmessages;

@ViewScoped
@ManagedBean
public class GerenciarAluno {
    private Aluno aluno, selecionado;
    private EntityPersist ep;
    private String busca, param;
    private List<Aluno> alunos;
    private Gmessages msg = new Gmessages();
    
    public GerenciarAluno() {
        System.out.println("Ativado");
        selecionado = new Aluno();
        aluno = new Aluno();
        ep = new EntityPersist();
        alunos = ep.search(Aluno.class);
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
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
    
    public void consultarAluno(ActionEvent ae) {
        if(busca.trim().equals(""))
            alunos = ep.search(Aluno.class);
        else
            alunos = ep.search(Aluno.class, new CriteriaGroup("eq", param, busca, null));
    }
    
    public void selectAluno(ActionEvent ae) {
        System.out.println("DEU!");
        selecionado = (Aluno) ae.getComponent().getAttributes().get("aluno");
        System.out.println(selecionado.getNome()  );
    }
    
    public void alterarAluno(ActionEvent ae) {
        System.out.println("Alterando");
        try {
            ep.update(selecionado);
            msg.alterar(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
