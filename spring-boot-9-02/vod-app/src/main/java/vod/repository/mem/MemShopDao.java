package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.ShopDao;
import vod.model.Shop;
import vod.model.Supplement;

import java.util.List;
import java.util.stream.Collectors;

@Repository("ShopDao")
public class MemShopDao implements ShopDao {

    @Override
    public List<Shop> findAll() {
        return SampleData.shops;
    }

    @Override
    public Shop findById(int id) {
        return SampleData.shops.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Shop> findBySupplement(Supplement m) {
        return SampleData.shops.stream().filter(c -> c.getSupplements().contains(m)).collect(Collectors.toList());
    }

    @Override
    public Shop add(Shop m) {
        int max = SampleData.shops.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.shops.add(m);
        return m;
    }
}
