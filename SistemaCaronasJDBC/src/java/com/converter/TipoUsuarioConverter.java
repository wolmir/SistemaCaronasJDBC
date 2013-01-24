package com.converter;

import com.model.entity.TipoUsuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author thiago
 */
@FacesConverter(value = "TipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            return component.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            TipoUsuario tipoUsuario = (TipoUsuario) value;
            String key = tipoUsuario.getTipoUsuario();
            component.getAttributes().put(key, tipoUsuario);
            return tipoUsuario.getTipoUsuario();
        }
        return null;
    }
}
