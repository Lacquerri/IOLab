package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Shop;
import vod.model.Supplement;
import vod.repository.ShopDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataShopDao implements ShopDao {
    private final ShopRepository repository;

    @Override
    public List<Shop> findAll(){return repository.findAll();}

    @Override
    public Shop findById(int id){return repository.findById(id).orElse(null);}

    @Override
    public List<Shop> findBySupplement(Supplement m) {return repository.findAllBySupplement(m);}

    @Override
    public Shop add(Shop shop) {return repository.save(shop);}
}
