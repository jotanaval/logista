/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mar.mil.br.entity.Modelo;
import mar.mil.br.repository.ModeloRepository;

/**
 *
 * @author Junior
 */
@ManagedBean
@RequestScoped
public class ModeloBean {
    
    @EJB
    private ModeloRepository modeloRepository;
    
    private Modelo modelo = new Modelo();
    private List<Modelo>modelos = new ArrayList<Modelo>();
    
    
    public String save(){
        if (modelo.getId() == null) {
             this.modeloRepository.save(modelo);
        } else {
             this.modeloRepository.update(modelo);
        }
       
        return "modelos?faces-redirect=true";
     }
    public List<Modelo>getModelos(){
        modelos = this.modeloRepository.listarOrdenada();
        return modelos;
    }
    public String editar(){
        return "modelos?faces-redirect=true";
    }
    
    public void excluir(){
        
        try{
        this.modeloRepository.delete(modelo.getId());
        modelo = null;
        
        FacesMessage msg =  new FacesMessage("Modelo removido com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }catch(Exception e){
            FacesMessage msg =  new FacesMessage("Modelo não pode ser excluido pois existe viatura com este modelo!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    
}
