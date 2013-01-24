package com.converter;

import com.model.entity.Veiculo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Usuario
 */
@FacesConverter(value = "VeiculoConverter")
public class VeiculoConverter implements Converter {

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
            Veiculo veiculo = (Veiculo) value;
            String key = veiculo.getPlaca();
            component.getAttributes().put(key, veiculo);
            return veiculo.getPlaca();
        }
        return null;
    }
}
