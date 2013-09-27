/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import com.entity.Professor;
import com.hibernate.HibernateUtil;
import com.persist.EntityPersist;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        ep.save(professor);
    }
    
    public void consultarProfessor(String nome){
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String query = "SELECT * FROM Professor WHERE nome LIKE '%"
                    +nome+"%'";
            professores = session.createSQLQuery(query).
                    addEntity(Professor.class).list();
            for(Professor prof: professores){
                System.out.println(prof.getNome());
            }
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void excluirProfessor(int id){}
}