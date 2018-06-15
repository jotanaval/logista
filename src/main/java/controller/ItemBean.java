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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mar.mil.br.entity.Item;
import mar.mil.br.entity.Manutencao;
import mar.mil.br.repository.ItemRepository;
import mar.mil.br.repository.ManutencaoRepository;

/**
 *
 * @author Junior
 */
@ManagedBean
@ViewScoped
public class ItemBean {

    
    @EJB
    private ManutencaoRepository manutencaoRepository;
    @EJB
   private ItemRepository itemRepository;  
    
   List<Item>itens = new ArrayList<Item>();
   Item item = new Item();
   private Long manutencaoID;
 
   
   public String manutencaoSalvarItem(){
       
       if(item.getId()== null){
            Manutencao m =   manutencaoRepository.findById(manutencaoID);
            item.setManutencao(m);
           itemRepository.save(item);
           
            FacesMessage msg =  new FacesMessage("Item salvo com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
       }else{
           
           itemRepository.update(item);
           
            FacesMessage msg =  new FacesMessage("Dados alterados com sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
       }
       
     this.item = new Item();
     return "item";
   }
    public List<Item> getItens() {
        itens = itemRepository.findAll();
        return itens;
    }
    
    public void excluir(){
             this.itemRepository.delete(itemSelecionado.getId());
             itemSelecionado = null;
             
             FacesMessage msg =  new FacesMessage("Exclusão realizada com sucesso!");
             FacesContext.getCurrentInstance().addMessage(null, msg);
      
    }
//    public String editar(){
//        return "addItem";
//    }
    
    //===============TRABALHANDO COM MODAL=================================================
    private Item itemSelecionado;
    private Item itemEdicao= new Item();
   
    public void novoItem(){
        item = new Item();
    }
    
    public Item getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Item itemSelecionado) {
          System.out.println("chamando............");
        this.itemSelecionado = itemSelecionado;
    }

    public Item getItemEdicao() {
        return itemEdicao;
    }

    public void setItemEdicao(Item itemEdicao) {
        this.itemEdicao = itemEdicao;
    }
    
    
    //=================================================================

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
      
        this.item = item;
    }

    public Long getManutencaoID() {
        return manutencaoID;
    }

    public void setManutencaoID(Long manutencaoID) {
        this.manutencaoID = manutencaoID;
    }
   

   
     
     
    
}
