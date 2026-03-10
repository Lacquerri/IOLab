package vod.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.repository.ShopDao;
import vod.repository.ProducerDao;
import vod.repository.SupplementDao;
import vod.model.Shop;
import vod.model.Producer;
import vod.model.Supplement;
import vod.service.SupplementService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SupplementServiceBean implements SupplementService {

    private static final Logger log = Logger.getLogger(SupplementService.class.getName());

    private ProducerDao producerDao;
    private ShopDao shopDao;
    private SupplementDao supplementDao;

    public SupplementServiceBean(ProducerDao producerDao, ShopDao shopDao, SupplementDao supplementDao) {
        this.producerDao = producerDao;
        this.shopDao = shopDao;
        this.supplementDao = supplementDao;
    }

    public List<Supplement> getAllSupplements() {
        log.info("searching all supplements...");
        return supplementDao.findAll();
    }

    public List<Supplement> getSupplementsByProducer(Producer d) {
        log.info("serching supplements by producer " + d.getId());
        return supplementDao.findByProducer(d);
    }

    public List<Supplement> getSupplementsInShop(Shop c) {
        log.info("searching supplements in shop " + c.getId());
        return supplementDao.findByShop(c);
    }

    public Supplement getSupplementById(int id) {
        log.info("searching supplements by id " + id);
        return supplementDao.findById(id);
    }

    public List<Shop> getAllShops() {
        log.info("searching all shops");
        return shopDao.findAll();
    }

    public List<Shop> getShopsBySupplement(Supplement m) {
        log.info("searching shops by supplement " + m.getId());
        return shopDao.findBySupplement(m);
    }

    public Shop getShopById(int id) {
        log.info("searching shop by id " + id);
        return shopDao.findById(id);
    }

    public List<Producer> getAllProducers() {
        log.info("searching all producers");
        return producerDao.findAll();
    }

    public Producer getProducerById(int id) {
        log.info("searching producer by id " + id);
        return producerDao.findById(id);
    }

    @Override
    public Supplement addSupplement(Supplement m) {
        log.info("about to add supplement " + m);
        return supplementDao.add(m);
    }

    @Override
    public Producer addProducer(Producer d) {
        log.info("about to add producer " + d);
        return producerDao.add(d);
    }

}
