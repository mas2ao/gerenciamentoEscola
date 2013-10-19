package gerenciamento;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class GerenciamentoLogin {
    public String autenticar() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("authenticated", true);
        return "/faces/index.xhtml";
    }
}
