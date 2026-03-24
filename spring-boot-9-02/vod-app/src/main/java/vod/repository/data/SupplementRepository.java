package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Shop;
import vod.model.Supplement;

public interface SupplementRepository extends JpaRepository<Supplement, Integer> {
}
