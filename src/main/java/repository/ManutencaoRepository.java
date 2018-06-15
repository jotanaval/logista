/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.repository;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import mar.mil.br.entity.Manutencao;
import mar.mil.br.generics.GenericDAO;

/**
 *
 * @author Junior
 */
@Stateless
public class ManutencaoRepository extends  GenericDAO<Manutencao>{

    public ManutencaoRepository() {
        super(Manutencao.class);
    }
    
    public List<Manutencao> prontificadas() {
         Query query = manager.createQuery("select m from Manutencao m where m.dataPrintificacao is not null ", Manutencao.class);
         return query.getResultList();
    }
    
    
    public List<Manutencao> emAndamento() {
      
        Query query = manager.createQuery("select m from Manutencao m where m.apresentacao is not null  and m.dataPrintificacao  is null", Manutencao.class);
         return query.getResultList();
    }
    
     public List<Manutencao> andamentoOm() {
      
        Query query = manager.createQuery("select m from Manutencao m where m.apresentacao is null  and m.dataPrintificacao  is null", Manutencao.class);
         return query.getResultList();
    }

    public BigDecimal findAllValorToral() {
        Query query = manager.createQuery("select sum(m.orcamento) from Manutencao m ", Manutencao.class);
         return (BigDecimal) query.getSingleResult();
    }

    public Long findAllProntificadas() {
        Query query = manager.createQuery("select count(m) from Manutencao m where m.dataPrintificacao is not null ", Manutencao.class);
         return (Long) query.getSingleResult();
    }

    public Long findAllTotalProgem() {
      Query query = manager.createQuery("select count(m) from Manutencao m where m.dataPrintificacao is null ", Manutencao.class);
         return (Long) query.getSingleResult();
    }
       
    
    
    
       
}
