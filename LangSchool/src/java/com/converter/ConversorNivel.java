package com.converter;

import com.entity.Nivel;
import gerenciamento.GerenciarNivel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Nivel.class ,value = "nivel")
public class ConversorNivel implements Converter {
    private static GerenciarNivel gerenNivel = new GerenciarNivel();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string != null && !string.trim().equals("")) {
            for(Nivel nivel : gerenNivel.getNiveis()) {
                if(nivel.getNome().equals(string))
                    return nivel;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if(obj == null || !(obj instanceof Nivel)) 
            return null;
        return ((Nivel)obj).getNome();
    }
}
