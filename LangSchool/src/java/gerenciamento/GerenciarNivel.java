package gerenciamento;

import com.entity.Nivel;
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
public class GerenciarNivel {
    private Nivel nivel, selecionado;
    private EntityPersist ep;
    private String busca, param;
    private List<Nivel> niveis;
    private boolean isAtivo;
    private Gmessages msg = new Gmessages();
    private GerenciarCurso cursoMan = new GerenciarCurso();

    public GerenciarNivel() {
        System.out.println("Ativado");
        selecionado = new Nivel();
        nivel = new Nivel();
        ep = new EntityPersist();
        niveis = ep.search(Nivel.class, new CriteriaGroup("eq", "estado", "ativo", nivel));
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
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

    public List<Nivel> getNiveis() {
        return niveis;
    }

    public void setNiveis(List<Nivel> niveis) {
        this.niveis = niveis;
    }

    public Nivel getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Nivel selecionado) {
        this.selecionado = selecionado;
    }

    public boolean isIsAtivo() {
        return isAtivo;
    }

    public void setIsAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }

    public GerenciarCurso getCursoMan() {
        return cursoMan;
    }

    public void setCursoMan(GerenciarCurso cursoMan) {
        this.cursoMan = cursoMan;
    }

    public void cadastrarNivel(ActionEvent ae) {
        System.out.println("Cadastrando..");
        try {
            ep.save(nivel);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarNivel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarNivel(ActionEvent ae) {
        if(busca.trim().equals(""))
            niveis = ep.search(Nivel.class, new CriteriaGroup("eq", "estado", "ativo", null));
        else if(!param.equals("estado")) {
            niveis = ep.search(Nivel.class, new CriteriaGroup("eq", param, busca, null),
                    new CriteriaGroup("eq", "estado", "ativo", null));
        } else
            niveis = ep.search(Nivel.class, new CriteriaGroup("eq", param, busca, null));
    }

    public void selectNivel(ActionEvent ae) {
        System.out.println("DEU!");
        selecionado = (Nivel) ae.getComponent().getAttributes().get("nivel");
        setIsAtivo(!"inativo".equals(selecionado.getEstado()));
    }

    public void alterarNivel(ActionEvent ae) {
        System.out.println("Alterando");
        try {
            ep.update(selecionado);
            msg.alterar(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarNivel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removerNivel(ActionEvent ae) {
        System.out.println("Removendo");
        selecionado.setEstadoInativo();
        try {
            ep.update(selecionado);
            msg.remover(ae);
            busca = "";
            param = "Nome";
            consultarNivel(ae);
        } catch (Exception ex) {
            Logger.getLogger(GerenciarNivel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ativar(ActionEvent ae) {
        selecionado.setEstadoAtivo();
        msg.ativado(ae);
        setIsAtivo(false);
    }
    
    public void print(ActionEvent ae) {
        System.out.println(nivel.getCurso().getNome());
    }
}
