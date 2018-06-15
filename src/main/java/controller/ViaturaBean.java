/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mar.mil.br.entity.Modelo;
import mar.mil.br.entity.Viatura;
import mar.mil.br.repository.ModeloRepository;
import mar.mil.br.repository.ViaturaRepository;
import mar.mil.br.usuario.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Junior
 */
@ManagedBean
@ViewScoped
public class ViaturaBean {
    
    @EJB
    ViaturaRepository viaturaRepositorio;
    @EJB
    private ModeloRepository modeloRepository;    
    private Viatura viatura = new Viatura();
    private Modelo modelo = new Modelo();
    private List<Viatura>findAll= new ArrayList<>(); 
    private Viatura viaturaSelecionada;
   //este atributo é para fazer o relacionamento na hora da gravação
   Long modeloID;   
   //pegando usuario logado e adicionando o nome dele a atualização
   String modificador = SecurityContextHolder.getContext().getAuthentication().getName();
   //=============================================================================

    public Viatura getViaturaSelecionada() {
        return viaturaSelecionada;
    }
    public void setViaturaSelecionada(Viatura viaturaSelecionada) {
        this.viaturaSelecionada = viaturaSelecionada;
    }
   public void novaViatura(){
       viatura = new Viatura();
   }
   //=============================================================================
    public String save(){
        if(viatura.getId() == null){
             Modelo m =  this. modeloRepository.findById(this.modeloID);
             this.viatura.setModificador(modificador);
             this.viatura.setModelo(m);
             viatura.setUltimaAtualizacao(new Date());
              this.viaturaRepositorio.save(viatura);
              FacesMessage msg =  new FacesMessage("viatura cadastrada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            
             this.viatura.setModificador(modificador);
             viatura.setUltimaAtualizacao(new Date());
              this.viaturaRepositorio.update(viatura); 
              FacesMessage msg =  new FacesMessage("viatura atualizada com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }    
       this.viatura = null;
       this.findAll=null;
        return null;
    }
    public String editar(){
        return "addViatura";
    }
    public void excluir(){
        this.viaturaRepositorio.delete(viaturaSelecionada.getId());
        viaturaSelecionada = null;
        
        FacesMessage msg =  new FacesMessage("viatura removida com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }    
//++++++++++++++++++++++++++++++++++++++++++++++++++
    public List<Viatura> getFindAll() {
        this.findAll = this.viaturaRepositorio.ordenadas();
        return findAll;
    }
    //método usado para mostrar as viaturas no combo de seleção da manutenção
    public List<Viatura> getOrdenadas() {
        this.findAll = this.viaturaRepositorio.ordenadas();
        return findAll;
    }
    //=============================Consulta de acordo com a OM======================================================
    public List<Viatura> getFindAllDefguranca() {   
        
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario OmLogado = this.viaturaRepositorio.findOneLogadoOm(login);
        String om = OmLogado.getOm();
        String DivAnf = "DivAnf" ;
        List<Viatura> findAllOm = new ArrayList<>();        
        if(OmLogado.getOm().equals(DivAnf)){
          findAllOm = this.viaturaRepositorio.ordenadas();         
        }else{
           findAllOm = this.viaturaRepositorio.findAllOm(om);
        }        
        return findAllOm  ;        
    }
    
    //==============================================================================================================
    public Viatura getViatura() {
        return viatura;
    }
    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }
    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    public Long getModeloID() {
        return modeloID;
    }
    public void setModeloID(Long modeloID) {
        this.modeloID = modeloID;
    }
    
}
