package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Shop;
import vod.model.Supplement;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    List<Shop> findAllByNameContaining(String name);
    @Query("select c from Shop c inner join c.supplements supplement where supplement=:supplement")
    List<Shop> findAllBySupplement(@Param("supplement") Supplement supplement);
}
