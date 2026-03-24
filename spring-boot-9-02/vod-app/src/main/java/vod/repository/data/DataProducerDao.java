package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Producer;
import vod.model.Shop;
import vod.model.Supplement;
import vod.repository.ProducerDao;
import vod.repository.ShopDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataProducerDao implements ProducerDao {

    private final ProducerRepository repository;
    @Override
    public List<Producer> findAll(){return repository.findAll();}
    @Override

    public Producer findById(int id){return repository.findById(id).orElse(null);}
    @Override
    public Producer add(Producer d){return repository.save(d);}

}
