/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import mar.mil.br.entity.MetasFisicas;
import mar.mil.br.generics.GenericDAO;

/**
 *
 * @author Junior
 */
@Stateless
public class MetasRepository extends GenericDAO<MetasFisicas> {

    public MetasRepository() {
        super(MetasFisicas.class);
    }

    public List<MetasFisicas> findAllOrderByASC() {
        Query query = manager.createQuery("select m from MetasFisicas m order by m.anoMetas ASC", MetasFisicas.class);
         return query.getResultList();
    }
    
    public List<MetasFisicas> findAllmetasFisicas(String mtNome ) {
        
        String jpql = "select m from MetasFisicas m where m.mtNome = ?1";
                
       List<MetasFisicas>metasFisicas = manager.createQuery(jpql, MetasFisicas.class)
              .setParameter(1, mtNome)
              .getResultList();
      
         return metasFisicas;
    }
    
    
}
