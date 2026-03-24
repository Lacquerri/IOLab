package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Shop;
import vod.model.Supplement;
import vod.repository.ShopDao;

import java.util.List;

@Repository

public class JpaShopDao implements ShopDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> findAll(){
        return entityManager
                .createQuery("select s from Shop s")
                .getResultList();
    }
    @Override
    public Shop findById(int id){
        return entityManager.find(Shop.class, id);
    }

    @Override
    public List<Shop> findBySupplement(Supplement m){
        return entityManager
                .createQuery("select s from Shop s inner join s.supplements supplement where supplement=:supplement")
                .setParameter("supplement", m)
                .getResultList();
    }

    @Override
    public Shop add(Shop shop){
     entityManager.persist(shop);
     return shop;
    }

}
