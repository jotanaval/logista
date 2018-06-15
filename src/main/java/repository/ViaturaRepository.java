/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import mar.mil.br.entity.Modelo;
import mar.mil.br.entity.Viatura;
import mar.mil.br.generics.GenericDAO;
import mar.mil.br.usuario.Usuario;

/**
 *
 * @author Junior
 */
@Stateless
public class ViaturaRepository extends GenericDAO<Viatura>{

    public ViaturaRepository() {
        super(Viatura.class);
    }
    public List<Viatura> findAllNome() {
        String situacao = null;
        Query query = manager.createQuery("select v.cfn from Viatura v ", Viatura.class);
         return query.getResultList();
    }
     public List<Viatura> ordenadas() {
         Query query = manager.createQuery("select v from Viatura v order by v.om ASC", Viatura.class);
         return query.getResultList();
  
    }

    public Usuario findOneLogadoOm(String login) {
      String jpql = "select u from Usuario u where u.login = :login";
      return this.manager
              .createQuery(jpql,Usuario.class)
              .setParameter("login", login)
              .getSingleResult();
    }

    public List<Viatura> findAllOm(String om) {
        String jpql = "select v from Viatura v where v.om = :om";
      return this.manager
              .createQuery(jpql,Viatura.class)
              .setParameter("om", om)
              .getResultList();
    }
    
}
