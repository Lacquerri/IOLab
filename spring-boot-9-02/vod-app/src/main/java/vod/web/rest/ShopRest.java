package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.Shop;
import vod.model.Supplement;
import vod.service.ShopService;
import vod.service.SupplementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ShopRest {
    private final ShopService shopService;
    private final SupplementService supplementService;

    @GetMapping("/shops")
    List<Shop> getShops() {
        log.info("about to retrive shops list");
        List<Shop> shops = shopService.getAllShops();
        log.info("{} shops found", shops.size());
        return shops;
    }

    @GetMapping("/shops/{id}")
    ResponseEntity<Shop> getShop(@PathVariable("id") int id){
        log.info("about to retrive shop {}", id);
        Shop shop = shopService.getShopById(id);
        log.info("shop found: {}", shop);
        if(shop!=null){
            return ResponseEntity.status(200).body(shop);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/supplements/{supplementId}/shops")
    ResponseEntity<List<Shop>> getShopsWithSupplement(@PathVariable("supplementId") int supplementId){
        log.info("about to retrive shops with supplement {}", supplementId);
        Supplement supplement = supplementService.getSupplementById(supplementId);
        if(supplement==null){
            return ResponseEntity.notFound().build();
        }
        else{
            List<Shop> shops = shopService.getShopsBySupplement(supplement);
            log.info("theres {} shops with supplement: {}", shops.size(), supplement.getName());
            return ResponseEntity.ok(shops);
        }
    }
}
