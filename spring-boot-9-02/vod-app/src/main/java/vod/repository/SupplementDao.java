package vod.repository;

import vod.model.Shop;
import vod.model.Producer;
import vod.model.Supplement;

import java.util.List;

public interface SupplementDao {

    List<Supplement> findAll();

    Supplement findById(int id);

    List<Supplement> findByProducer(Producer d);

    List<Supplement> findByShop(Shop c);

    Supplement add(Supplement m);

}
