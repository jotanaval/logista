package mar.mil.br.repository;


import javax.ejb.Stateless;
import mar.mil.br.entity.Item;
import mar.mil.br.generics.GenericDAO;

/**
 *
 * @author Junior
 */
@Stateless
public class ItemRepository extends GenericDAO<Item> {

    public ItemRepository() {
        super(Item.class);
    }
    
     

   
    
}
