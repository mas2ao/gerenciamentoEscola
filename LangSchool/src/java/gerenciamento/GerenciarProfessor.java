
package gerenciamento;

import com.entity.Professor;
import com.hibernate.HibernateUtil;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class GerenciarProfessor {
    private Professor professor;
    private List<Professor> professores;
    private EntityPersist ep;
    
    public GerenciarProfessor(){
        professor = new Professor();
        ep = new EntityPersist();
        professores = ep.search(Professor.class, 
                new CriteriaGroup("eq","estado","ativo",null));
    }
    
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    
    public Professor getProfessor(){
        return this.professor;
    }
    
    public List<Professor> getProfessores(){
        return this.professores;
    }
    
    public void adicionarProfessor(){
        try {
            ep.save(professor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void consultarProfessor(String nome){
        professores = ep.search(Professor.class, 
                new CriteriaGroup("like", "nome", nome, null));
    }
    
    public void excluirProfessor(int id){}
}