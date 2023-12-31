package toyproject.toyshop.repository;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Repository;
import toyproject.toyshop.domain.item.Item;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

     public Item findOne(Long id) {
        return em.find(Item.class, id);
     }

     public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
     }
}
