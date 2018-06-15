/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.conversor;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import mar.mil.br.controller.ViaturaBean;
import mar.mil.br.entity.Viatura;


/**
 *
 * @author Junior
 */
@FacesConverter("viatura")
public class ConversorViatura  implements Converter{

    ViaturaBean bean = new ViaturaBean();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null){
            Long id = Long.valueOf(value);
            
            for(Viatura viatura : bean.getFindAll()){
                if(id.equals(viatura.getId())){
                    return viatura;
                }
                
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
        if(value != null  & value.equals("")){
            Viatura viatura = (Viatura)value;
            
            return String.valueOf(viatura.getId());
        }
        return null;
    }

    
    
}
