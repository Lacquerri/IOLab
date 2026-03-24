package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Producer;
import vod.model.Shop;
import vod.model.Supplement;
import vod.repository.SupplementDao;

import java.util.List;

@Repository
@Primary
public class JpaSupplementDao implements SupplementDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Supplement> findAll(){
        return entityManager.createQuery("select m from Supplement m").getResultList();
    }

    @Override
    public Supplement findById(int id){return entityManager.find(Supplement.class, id);}

    @Override
    public List<Supplement> findByProducer(Producer d){
        return entityManager
                .createQuery("select m from Supplement m where m.producer=:producer")
                .setParameter("producer", d)
                .getResultList();
    }

    @Override
    public List<Supplement> findByShop(Shop d){
        return entityManager
                .createQuery("select m from Supplement m inner join m.shops shop where shop=:shop")
                .setParameter("shop", d)
                .getResultList();
    }

    @Override
    public Supplement add(Supplement m){
        entityManager.persist(m);
        return m;
    }
}
