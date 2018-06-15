/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mar.mil.br.entity.MetasFisicas;
import mar.mil.br.repository.MetasRepository;

/**
 *
 * @author Junior
 */
@ManagedBean
@RequestScoped
public class MetasBean {
    
    @EJB
    private MetasRepository metasRepository;
    
    MetasFisicas metasFisicas = new MetasFisicas();
    
    public String salvar(){
        if(metasFisicas.getId()==null){
            metasRepository.save(metasFisicas);
            
        }else{
            metasRepository.update(metasFisicas);
            
        }
        this.metasFisicas = new MetasFisicas();
        metasFisicas = new MetasFisicas();
        return null;
    }
    public String editar(){
        return "metasFisicas";
    }
    
    public String excluir(Long id){
        this.metasRepository.delete(metasFisicas.getId());
        return null;
    }
    public List<MetasFisicas>getFindAll(){
        List<MetasFisicas>todasOrdenadas = this.metasRepository.findAllOrderByASC();
        return todasOrdenadas;
    }

    public MetasFisicas getMetasFisicas() {
        return metasFisicas;
    }

    public void setMetasFisicas(MetasFisicas metasFisicas) {
        this.metasFisicas = metasFisicas;
    }
    
    
    
}
