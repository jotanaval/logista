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

/**
 *
 * @author Junior
 */
@Stateless
public class ModeloRepository extends GenericDAO<Modelo> {

    public ModeloRepository() {
        super(Modelo.class);
    }

    public List<Modelo> listarOrdenada() {
        String situacao = null;
        Query query = manager.createQuery("select v from Modelo v order by v.modelo asc", Modelo.class);
         return query.getResultList();
    }

}
