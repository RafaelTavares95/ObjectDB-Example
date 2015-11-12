/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ATP;

/**
 *
 * @author Rafael
 */
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class atpDAO {
  
  // Injected database connection:
  @PersistenceContext private EntityManager em;

  // Stores a new player
  public void persist(Player player) {
    em.persist(player);
  }
  
   // Retrieves all the players
  public List<Player> getAllPlayers() {
    TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p ORDER BY p.ranking", Player.class);
    return query.getResultList();
  }
}
