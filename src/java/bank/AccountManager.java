/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HugoCésar
 */
@Stateless
public class AccountManager {
    @PersistenceContext(unitName = "LockingPU")
    private EntityManager em;

    public void create(Account a) {
        em.persist(a);
    }
    
    
    public Account read(Long id){
        return em.find(Account.class, id);
        
    }
    
    
    public void update(Account a){
    
        em.merge(a);
    }

}
