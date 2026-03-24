package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Producer;
import vod.model.Shop;
import vod.model.Supplement;
import vod.service.ShopService;
import vod.service.SupplementService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SupplementController {
    private final ShopService shopService;
    private final SupplementService supplementService;

    @GetMapping("/supplements") // /supplements?shopId=3
    public String getSupplements(
            Model model,
            @RequestParam(value = "shopId", required = false)Integer shopId,
            @RequestParam(value = "producerId", required = false)Integer producerId
    ) {
        log.info("about to display supplements in shop {}", shopId );
        if (shopId != null) {
            Shop shop = shopService.getShopById(shopId);
            List<Supplement> supplements = shopService.getSupplementsInShop(shop);
            model.addAttribute("supplements", supplements);
            model.addAttribute("title", "Supplements in shop " + shop.getName());
        } else if (producerId != null) {
            Producer producer = supplementService.getProducerById(producerId);
            List<Supplement> supplements = supplementService.getSupplementsByProducer(producer);
            model.addAttribute("supplements", supplements);
            model.addAttribute("title", "Supplements from producer " + producer.getName());
        } else {
            List<Supplement> supplements = supplementService.getAllSupplements();
            model.addAttribute("supplements", supplements);
            model.addAttribute("title", "Supplements");
        }
        return "supplementsView";

    }
}
