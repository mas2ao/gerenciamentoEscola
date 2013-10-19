package gerenciamento;

import com.entity.Aluno;
import com.entity.Matricula;
import com.entity.Nota;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import messages.Gmessages;

@ViewScoped
@ManagedBean
public class GerenciarMatricula {
    private Matricula matricula, selecionado;
    private EntityPersist ep;
    private String busca, param;
    private List<Matricula> matriculas;
    
    private boolean isAtivo;
    private GerenciarAluno alunoMan = new GerenciarAluno();
    private GerenciarTurma turmaMan = new GerenciarTurma();
    private Gmessages msg = new Gmessages();

    public GerenciarMatricula() {
        System.out.println("Ativado");
        selecionado = new Matricula();
        matricula = new Matricula();
        ep = new EntityPersist();
        matriculas = ep.search(Matricula.class);
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Matricula getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Matricula selecionado) {
        this.selecionado = selecionado;
    }

    public boolean isIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public GerenciarAluno getAlunoMan() {
        return alunoMan;
    }

    public void setAlunoMan(GerenciarAluno alunoMan) {
        this.alunoMan = alunoMan;
    }

    public GerenciarTurma getTurmaMan() {
        return turmaMan;
    }

    public void setTurmaMan(GerenciarTurma turmaMan) {
        this.turmaMan = turmaMan;
    }

    public void cadastrarMatricula(ActionEvent ae) {
        if(matricula.getTurma().getVagas() == 0) {
            msg.falhaCadastro(ae);
            return;
        }
        matricula.setDataMatricula(new Date());
        try {
            ep.save(matricula);
            ep.save(new Nota());
        } catch (Exception ex) {
            Logger.getLogger(GerenciarMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarMatricula(ActionEvent ae) {
        System.out.println("ponto1");
        if(busca.trim().equals(""))
            matriculas = ep.search(Matricula.class);
        else if(param.equals("nome")) {
            System.out.println("ponto2");
            List<Aluno> aluno = ep.search(Aluno.class, new CriteriaGroup("eq", "estado", "ativo", null),
                    new CriteriaGroup("eq", param, busca, null));
            System.out.println("ponto3");
            if(!aluno.isEmpty())
                matriculas = ep.search(Matricula.class, 
                    new CriteriaGroup("eq", "aluno", aluno.get(0), null));
            else
                matriculas = null;
            System.out.println("ponto4");
        } else
            matriculas = ep.search(Matricula.class, new CriteriaGroup("eq", param, busca, null));
    }

    public void selectMatricula(ActionEvent ae) {
        System.out.println("DEU!");
        selecionado = (Matricula) ae.getComponent().getAttributes().get("matricula");
    }

    public void alterarMatricula(ActionEvent ae) {
        System.out.println("Alterando");
        try {
            ep.update(selecionado);
            msg.alterar(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removerMatricula(ActionEvent ae) {
        System.out.println("Removendo");
        try {
            ep.delete(selecionado);
            msg.remover(ae);
            busca = "";
            param = "Nome";
            consultarMatricula(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void change(ValueChangeEvent vc) {
        System.out.println("DEU");
    }
}
