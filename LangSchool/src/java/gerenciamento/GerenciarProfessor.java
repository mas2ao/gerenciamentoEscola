/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import com.entity.Professor;
import javax.faces.bean.ManagedBean;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author john
 */
@ManagedBean
public class GerenciarProfessor {
    private SessionFactory factory = configure();
    private String nome;
    private String email;
    private String telefone;
    
    private SessionFactory configure(){
        return new AnnotationConfiguration().configure().
                buildSessionFactory();
    }
    
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
    
    public void cadastrarProfessor(){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setEmail(email);
            professor.setTelefone(telefone);
            professor.setId((Integer) session.save(professor));
            tx.commit();
        } catch (HibernateException ex){
            if (tx != null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public void excluirProfessor(){
    }
    
    public void consultarProfessor(){
        
    }
}