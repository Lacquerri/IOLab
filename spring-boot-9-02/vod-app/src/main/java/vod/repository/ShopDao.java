package vod.repository;

import vod.model.Shop;
import vod.model.Supplement;

import java.util.List;

public interface ShopDao {

    List<Shop> findAll();

    Shop findById(int id);

    List<Shop> findBySupplement(Supplement m);

}
