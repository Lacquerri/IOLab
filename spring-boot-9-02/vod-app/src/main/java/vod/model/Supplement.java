package vod.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    private String flavor;
    @NotNull//url

    @ManyToOne
    @JoinColumn(name= "producer_id")
    private Producer producer;//relacja do rezysera - kolejny obiekt danych w uproszczeniu założenie że jeden film ma 1 reżysera
    @ManyToMany
    @JoinTable(
            name = "supplement_shop",
            joinColumns = @JoinColumn(name = "supplement_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Shop> shops = new ArrayList<>();
//relacja wiele do wiele - bidirectional

    public Supplement(int id, String name, String flavor, Producer producer) {
        this.id = id;
        this.name = name;
        this.flavor = flavor;
        this.producer = producer;
    }

    public Supplement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public void addShop(Shop c) {
        this.shops.add(c);
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Supplement{" +
                "Name='" + name + '\'' +
                ", Producer=" + producer +
                '}';
    }
}
