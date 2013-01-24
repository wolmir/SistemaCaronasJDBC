package com.converter;

import com.model.entity.TipoVeiculo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author thiago
 */
@FacesConverter(value = "TipoVeiculoConverter")
public class TipoVeiculoConverter implements Converter {

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
            TipoVeiculo tipoVeiculo = (TipoVeiculo) value;
            String key = tipoVeiculo.getTipoVeiculo();
            component.getAttributes().put(key, tipoVeiculo);
            return tipoVeiculo.getTipoVeiculo();
        }
        return null;
    }

}
