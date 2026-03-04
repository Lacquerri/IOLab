package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vod.model.Shop;
import vod.service.ShopService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final ShopService shopService;
    public VodComponent(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostConstruct
    void init() {
        log.info("In post construct");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("on context refreshed");
        List<Shop> shops = shopService.getAllShops();
        log.info("Found {} shops", shops.size());
        shops.forEach(shop -> log.info("{}", shop));
    }
}
