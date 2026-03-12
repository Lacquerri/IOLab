package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Shop;
import vod.model.Supplement;
import vod.repository.ShopDao;
import vod.repository.SupplementDao;
import vod.service.ShopService;

import java.util.List;
import java.util.logging.Logger;

@Service
@Scope("prototype")
public class ShopServiceBean implements ShopService {

    private static final Logger log = Logger.getLogger(ShopService.class.getName());

    private ShopDao shopDao;
    private SupplementDao supplementDao;

    public ShopServiceBean(ShopDao shopDao, SupplementDao supplementDao) {
        log.info("creating shop service bean");
        this.shopDao = shopDao;
        this.supplementDao = supplementDao;
    }

    @Override
    public Shop getShopById(int id) {
        log.info("searching shop by id " + id);
        return shopDao.findById(id);
    }

    @Override
    public List<Supplement> getSupplementsInShop(Shop c) {
        log.info("searching supplements in shop " + c.getId());
        return supplementDao.findByShop(c);
    }

    @Override
    public List<Shop> getAllShops() {
        log.info("searching all shops");
        return shopDao.findAll();
    }

    @Override
    public List<Shop> getShopsBySupplement(Supplement m) {
        log.info("searching shops by supplement " + m.getId());
        return shopDao.findBySupplement(m);
    }

    @Override
    public Shop addShop(Shop m) {
        log.info("about to add shop " + m);
        return shopDao.add(m);
    }

}
