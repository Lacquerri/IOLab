package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Shop;
import vod.model.Supplement;
import vod.service.ShopService;
import vod.service.SupplementService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ShopController {
    private final ShopService shopService;
    private final SupplementService supplementService;

    @GetMapping("/shops") // /shops?supplementId=3
    String getShops(Model model, @RequestParam(value = "supplementId", required = false) Integer supplementId) {
        log.info("about to display shops");
        if (supplementId != null) {
            Supplement supplement = supplementService.getSupplementById(supplementId);
            List<Shop> shops = shopService.getShopsBySupplement(supplement);
            model.addAttribute("shops", shops);
            model.addAttribute("title", "Shops with supplement:" + supplement.getName());
        }else{
            List<Shop> shops = shopService.getAllShops();
            model.addAttribute("shops", shops);
            model.addAttribute("title", "Shops");

        }
        return "shopsView";

    }
}
