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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Shop;
import vod.model.Supplement;
import vod.service.ShopService;
import vod.service.SupplementService;
import vod.web.rest.dto.SupplementDTO;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class SupplementRest {
    private final ShopService shopService;
    private final SupplementService supplementService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
/*    private final ShopValidator validator;

    @InitBinder
    void initBinder(WebDataBinder binder) {binder.addValidators(validator);}*/

    @GetMapping("/supplements")
    List<Supplement> getSupplements() {
        log.info("about to retrive shops list");
        List<Supplement> supplements = supplementService.getAllSupplements();
        log.info("{} suplements found", supplements.size());
        return supplements;
    }

    @GetMapping("/supplements/{id}")
    ResponseEntity<Supplement> getSupplement(@PathVariable("id") int id){
        log.info("about to retrive supplement {}", id);
        Supplement supplement = supplementService.getSupplementById(id);
        log.info("shop found: {}", supplement);
        if(supplement!=null){
            return ResponseEntity.status(200).body(supplement);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/shop/{shopId}/supplement")
    ResponseEntity<List<Supplement>> getSupplementsInShop(@PathVariable("shopId") int shopId){
        log.info("about to retrive supplements from shop: {}", shopId);
        Shop shop = shopService.getShopById(shopId);
        if(shop==null){
            return ResponseEntity.notFound().build();
        }
        else{
            List<Supplement> supplements = supplementService.getSupplementsInShop(shop);
            log.info("theres {} supplements in shop: {}", supplements.size(), shop.getName());
            return ResponseEntity.ok(supplements);
        }
    }

    @PostMapping("/supplement")
    ResponseEntity<?> addSupplement(@RequestBody SupplementDTO supplementDTO){
        log.info("about to add supplement {}", supplementDTO);
        Supplement supplement = new Supplement();
        supplement.setName(supplementDTO.getName());
        supplement.setFlavor(supplementDTO.getFlavor());
        supplement.setProducer(supplementService.getProducerById(supplementDTO.getProducerId()));

        supplement = supplementService.addSupplement(supplement);
        log.info("supplement added: {}", supplement);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/"+supplement.getId())
                .build()
                .toUri())
                .body(supplement);
        //status(HttpStatus.CREATED).body(supplement);
    }

}
