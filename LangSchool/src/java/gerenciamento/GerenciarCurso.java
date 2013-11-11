package gerenciamento;

import com.entity.Curso;
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
public class GerenciarCurso {
    private Curso curso, selecionado;
    private String param, busca;
    private List<Curso> cursos;
    private boolean isAtivo;
    private EntityPersist ep;
    private Gmessages msg;
    
    public GerenciarCurso() {
        curso = new Curso();
        selecionado = new Curso();
        ep = new EntityPersist();
        msg = new Gmessages();
        cursos = ep.search(Curso.class, new CriteriaGroup("eq", "estado", "ativo", null));
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Curso selecionado) {
        this.selecionado = selecionado;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public boolean isIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }
    
    public void adicionarCurso(ActionEvent ae) {
        try {
            ep.save(curso);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarCurso(ActionEvent ae) {
        if(busca.trim().equals(""))
            cursos = ep.search(Curso.class, new CriteriaGroup("eq", "estado", "ativo", null));
        else if(!param.equals("estado")) {
            cursos = ep.search(Curso.class, new CriteriaGroup("eq", param, busca, null),
                    new CriteriaGroup("eq", "estado", "ativo", null));
        } else
            cursos = ep.search(Curso.class, new CriteriaGroup("eq", param, busca, null));
    }
    
    public void removerCurso(ActionEvent ae) {
        System.out.println("Removendo");
        selecionado.setEstadoInativo();
        try {
            ep.update(selecionado);
            msg.remover(ae);
            busca = "";
            param = "Nome";
            consultarCurso(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void selectCurso(ActionEvent ae) {
        System.out.println("DEU!");
        selecionado = (Curso) ae.getComponent().getAttributes().get("curso");
        setIsAtivo(!"inativo".equals(selecionado.getEstado()));
    }
    
    
    public void ativar(ActionEvent ae) {
        selecionado.setEstadoAtivo();
        msg.ativado(ae);
        setIsAtivo(false);
    }
}
