package vod.service;

import vod.model.Shop;
import vod.model.Supplement;

import java.util.List;

public interface ShopService {
//api zwraca nam wszystkie kina
    Shop getShopById(int id);

    List<Shop> getAllShops();

    List<Shop> getShopsBySupplement(Supplement m);

    List<Supplement> getSupplementsInShop(Shop c);

    Shop addShop(Shop m);
}
