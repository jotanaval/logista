/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mar.mil.br.repository;

import javax.ejb.Stateless;
import mar.mil.br.entity.Ctec;
import mar.mil.br.generics.GenericDAO;

/**
 *
 * @author Junior
 */
@Stateless
public class CtecRepository extends GenericDAO<Ctec>{

    public CtecRepository() {
        super(Ctec.class);
    }
    
    
    
}
