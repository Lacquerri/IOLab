package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Producer;
import vod.model.Shop;

public interface ProducerRepository extends JpaRepository<Producer, Integer> {
}
