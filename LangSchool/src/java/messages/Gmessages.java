/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author SirYuKill
 */
@ManagedBean
public class Gmessages {
    public void alterar(ActionEvent ae) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Alterado com sucesso!", "Pois é"));
    }
    public void remover(ActionEvent ae) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Removido com sucesso!", "Pois é"));
    }
    public void rematricular(ActionEvent ae) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Rematriculado com sucesso!", "Pois é"));
    }
    public void pago(ActionEvent ae) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Pagamento efetuado!", "Pois é"));
    }
    public void estornar(ActionEvent ae) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Estorno efetuado!", "Pois é"));
    }
    public void emitir(ActionEvent ae) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Emitindo...", "Pois é"));
    }
    
}
