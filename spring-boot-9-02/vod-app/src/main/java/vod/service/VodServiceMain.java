package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Shop;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find shops!");
        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        ShopService service = context.getBean(ShopService.class);

        List<Shop> shops = service.getAllShops();
        System.out.println(shops.size() + " shops found:");
        shops.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
