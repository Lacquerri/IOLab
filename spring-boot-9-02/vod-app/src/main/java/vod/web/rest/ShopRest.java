package vod.web.rest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Shop;
import vod.model.Supplement;
import vod.service.ShopService;
import vod.service.SupplementService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ShopRest {
    private final ShopService shopService;
    private final SupplementService supplementService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    /*private final ShopValidator validator;

    @InitBinder
    void initBinder(WebDataBinder binder) {binder.addValidators(validator);}
*/
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

    @PostMapping("/shops")
    ResponseEntity<?> addShop(@Validated @RequestBody Shop shop, Errors errors, HttpServletRequest request){
        log.info("about to add shop {}", shop);
        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream().map(oe->messageSource.getMessage(oe.getCode(),new Object[0], locale)).reduce("errors:\n", (accu,oe)->accu+oe+"\n");

            return ResponseEntity.badRequest().body(errorMessage);
        }

        shop = shopService.addShop(shop);
        log.info("shop added: {}", shop);
        return ResponseEntity.status(HttpStatus.CREATED).body(shop);
    }

}
