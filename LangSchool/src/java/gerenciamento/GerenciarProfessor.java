/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import com.entity.Professor;
import com.hibernate.HibernateUtil;
import com.persist.EntityPersist;
import com.util.CriteriaGroup;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author john
 */
@ManagedBean
public class GerenciarProfessor {
    private String nome;
    private String email;
    private String telefone;
    private List<Professor> professores;
    private EntityPersist ep = new EntityPersist();
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public List<Professor> getProfessores(){
        return this.professores;
    }
    
    public void cadastrarProfessor() {
        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setEmail(email);
        professor.setTelefone(telefone);
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