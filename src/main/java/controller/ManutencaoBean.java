/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.controller;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mar.mil.br.entity.Manutencao;
import mar.mil.br.entity.Viatura;
import mar.mil.br.repository.ManutencaoRepository;
import mar.mil.br.repository.ViaturaRepository;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Junior
 */
@ManagedBean
@ViewScoped
public class ManutencaoBean {

    @EJB
    private ManutencaoRepository manutencaoRepository;
    @EJB
    private ViaturaRepository viaturaRepository;
    
    private Manutencao manutencao = new Manutencao();
    private Long viaturaID;
    String modificador = SecurityContextHolder.getContext().getAuthentication().getName();
    
    private Manutencao manuSelecvionada;
    private Manutencao manuEdicao = new Manutencao();
//============================================
     
     public void novaManutencao(){
         manutencao = new Manutencao();
     }
//========================================================================================
    public String save() {
                 
      if (manutencao.getId() == null) {
          
            Viatura v = viaturaRepository.findById(viaturaID);
            this.manutencao.setAtualizador(modificador);
            this. manutencao.setViatura(v);
            this.manutencao.setUltimaAtualizacao(new Date());
            this.manutencaoRepository.save(manutencao);
            
            FacesMessage msg =  new FacesMessage("Cadastro realizado com sucesso !");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        } else {
         
           this.manutencao.setAtualizador(modificador);
           
           
           this.manutencao.setUltimaAtualizacao(new Date());
           this.manutencaoRepository.update(manutencao);
           
           FacesMessage msg =  new FacesMessage("Informações atualizadas com sucesso !");
            FacesContext.getCurrentInstance().addMessage(null, msg);
       }
             this.manutencao = new Manutencao();
           
             return "manutencao";
    }

    public List<Manutencao> getFindAll() {
        List<Manutencao> findAll = this.manutencaoRepository.findAll();
        return findAll;
    }
    
    public List<Manutencao> getProntificadas() {
        List<Manutencao> prontificadas = this.manutencaoRepository.prontificadas();
        return prontificadas;
    }
    public List<Manutencao> getEmAndamento() {
        List<Manutencao> emAndamento = this.manutencaoRepository.emAndamento();
        return emAndamento;
    }
     public List<Manutencao> getAndamentoOm() {
        List<Manutencao> emAndamento = this.manutencaoRepository.andamentoOm();
        return emAndamento;
    }
   
    
    public String editar(){
        return  "editarManutencao";
    }
    
    public String excluir(){
        this.manutencaoRepository.delete(manutencao.getId());
        
        FacesMessage msg =  new FacesMessage("Exclusão realizada com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        return null;
    }

    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public Long getViaturaID() {
        return viaturaID;
    }

    public void setViaturaID(Long viaturaID) {
        this.viaturaID = viaturaID;
    }

    public String getModificador() {
        return modificador;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }

    public Manutencao getManuSelecvionada() {
        return manuSelecvionada;
    }

    public void setManuSelecvionada(Manutencao manuSelecvionada) {
        this.manuSelecvionada = manuSelecvionada;
    }

    public Manutencao getManuEdicao() {
        return manuEdicao;
    }

    public void setManuEdicao(Manutencao manuEdicao) {
        this.manuEdicao = manuEdicao;
    }
    
    

}
