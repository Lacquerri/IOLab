package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Producer;
import vod.model.Shop;
import vod.model.Supplement;

import java.util.List;

public interface SupplementRepository extends JpaRepository<Supplement, Integer> {

    List<Supplement> findAllByProducer(Producer d);

    List<Supplement> findAllByShopsContaining(Shop c);
}
