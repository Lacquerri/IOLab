package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Producer;
import vod.model.Shop;
import vod.model.Supplement;
import vod.repository.SupplementDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataSupplementDao implements SupplementDao {
    private final SupplementRepository repository;

    @Override
    public List<Supplement> findAll(){return repository.findAll();}
    @Override
    public Supplement findById(int id){return repository.findById(id).orElse(null);}
    @Override
    public List<Supplement> findByProducer(Producer d){return repository.findAllByProducer(d);}
    @Override
    public List<Supplement> findByShop(Shop c){return repository.findAllByShopsContaining(c);}
    @Override
    public Supplement add(Supplement m){return repository.save(m);}
}
