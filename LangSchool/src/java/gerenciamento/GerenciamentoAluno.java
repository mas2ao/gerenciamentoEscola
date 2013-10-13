package gerenciamento;

import com.entity.Aluno;
import com.persist.EntityPersist;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean
public class GerenciamentoAluno {
    private Aluno aluno;
    private EntityPersist ep;
    
    public GerenciamentoAluno() {
        System.out.println("Ativado");
        aluno = new Aluno();
        ep = new EntityPersist();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void cadastrarAluno(ActionEvent ae) {
        try {
            ep.save(aluno);
        } catch (Exception ex) {
            Logger.getLogger(GerenciamentoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
