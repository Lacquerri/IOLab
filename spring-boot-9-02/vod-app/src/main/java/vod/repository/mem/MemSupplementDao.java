package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.SupplementDao;
import vod.model.Shop;
import vod.model.Producer;
import vod.model.Supplement;

import java.util.List;
import java.util.stream.Collectors;

@Repository("SupplementDao")
public class MemSupplementDao implements SupplementDao {
    @Override
    public List<Supplement> findAll() {
        return SampleData.supplements;
    }

    @Override
    public Supplement findById(int id) {
        return SampleData.supplements.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Supplement> findByProducer(Producer d) {
       return SampleData.supplements.stream().filter(m -> m.getProducer() == d).collect(Collectors.toList());
    }

    @Override
    public List<Supplement> findByShop(Shop c) {
        return SampleData.supplements.stream().filter(m -> m.getShops().contains(c)).collect(Collectors.toList());
    }

    @Override
    public Supplement add(Supplement m) {
        int max = SampleData.supplements.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.supplements.add(m);
        return m;
    }
}
