package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Shop;
import vod.model.Supplement;
import vod.repository.ShopDao;

import java.util.List;

@Component
public class DummyShopDao implements ShopDao {
    @Override
    public List<Shop> findAll() {
        return null;
    }

    @Override
    public Shop findById(int id) {
        return null;
    }

    @Override
    public List<Shop> findBySupplement(Supplement m) {
        return null;
    }
}
