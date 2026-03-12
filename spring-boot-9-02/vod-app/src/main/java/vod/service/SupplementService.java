package vod.service;

import vod.model.Producer;
import vod.model.Shop;
import vod.model.Supplement;

import java.util.List;

public interface SupplementService {


    List<Supplement> getAllSupplements();

    List<Supplement> getSupplementsByProducer(Producer d);

    Supplement getSupplementById(int id);

    Supplement addSupplement(Supplement m);

    List<Supplement> getSupplementsInShop(Shop d);

    List<Producer> getAllProducers();

    Producer getProducerById(int id);

    Producer addProducer(Producer d);
}
