package vod.repository.mem;

import vod.model.Shop;
import vod.model.Producer;
import vod.model.Supplement;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Shop> shops = new ArrayList<>();

    static List<Producer> producers = new ArrayList<>();

    static List<Supplement> supplements = new ArrayList<>();

    static {

        Producer kfd = new Producer(1, "KFD");
        Producer sfd = new Producer(2, "SFD");
        Producer allNutrition = new Producer(3, "All Nutrition");
        Producer olimp = new Producer(4, "Olimp");

        Supplement kreatynaKfd = new Supplement(1, "Kreatyna", "Zielone Jablko", kfd);
        Supplement cytrulinaKfd = new Supplement(2, "Cytrulina", "Brzoskwinia", kfd);

        Supplement kolagenSfd = new Supplement(3, "Kolagen", "Ananas", sfd);
        Supplement cytrulinaSfd = new Supplement(4, "Cytrulina", "Granat", sfd);

        Supplement kreatynaAllNut = new Supplement(5, "Kreatyna", "Pomarancza", allNutrition);
        Supplement witaminaD3 = new Supplement(6, "Witamina D3", "Bezsmakowe", allNutrition);

        Supplement wpc82 = new Supplement(7, "Bialko WPC 82", "Ciasteczkowy", olimp);
        Supplement magnez = new Supplement(8, "Magnez + B6", "Bezsmakowe", olimp);

        bind(kreatynaKfd, kfd);
        bind(cytrulinaKfd, kfd);

        bind(kolagenSfd, sfd);
        bind(cytrulinaSfd, sfd);

        bind(kreatynaAllNut, allNutrition);
        bind(witaminaD3, allNutrition);

        bind(wpc82, olimp);
        bind(magnez, olimp);

        Shop shopKfd = new Shop(1, "KFD", "https://photos05.redcart.pl/templates/images/description/6187/Image/1623418596-kfd-logo.png");
        Shop shopSfd = new Shop(2, "SFD", "https://galeriamlociny.pl/app/uploads/wayfinder/url_logo/3225.png");
        Shop strefaGladiatorow = new Shop(3, "Strefa Gladiatorow", "https://strefagladiatorow.pl/userdata/public/producers/69.jpg");
        Shop shopOlimp = new Shop(4, "Olimp", "https://content.zlotetarasy.pl/static/media/2021/11/25/c1b56df4-13b8-47d0-b4ef-146da0ab3b67.png");

        bind(shopKfd, cytrulinaKfd);
        bind(strefaGladiatorow, cytrulinaKfd);
        bind(strefaGladiatorow, kreatynaKfd);
        bind(strefaGladiatorow, kolagenSfd);

        bind(shopKfd, witaminaD3);
        bind(shopOlimp, witaminaD3);
        bind(shopOlimp, wpc82);
        bind(shopSfd, wpc82);
        bind(shopSfd, kolagenSfd);

        supplements.add(kreatynaKfd);
        supplements.add(cytrulinaKfd);
        supplements.add(kolagenSfd);
        supplements.add(cytrulinaSfd);
        supplements.add(kreatynaAllNut);
        supplements.add(witaminaD3);
        supplements.add(wpc82);
        supplements.add(magnez);

        producers.add(kfd);
        producers.add(sfd);
        producers.add(allNutrition);
        producers.add(olimp);

        shops.add(shopKfd);
        shops.add(shopSfd);
        shops.add(strefaGladiatorow);
        shops.add(shopOlimp);

    }

    private static void bind(Shop c, Supplement m) {
        c.addSupplement(m);
        m.addShop(c);
    }

    private static void bind(Supplement m, Producer d) {
        d.addSuplement(m);
        m.setProducer(d);
    }

}
