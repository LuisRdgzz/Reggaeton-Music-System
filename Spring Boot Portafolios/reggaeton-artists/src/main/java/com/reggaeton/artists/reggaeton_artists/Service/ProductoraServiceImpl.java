package com.reggaeton.artists.reggaeton_artists.Service;

import com.reggaeton.artists.reggaeton_artists.Entity.Productora;
import com.reggaeton.artists.reggaeton_artists.Repository.ProductoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoraServiceImpl implements ProductoraService {


    @Autowired
    private ProductoraRepository repository;

    @Override
    public List<Productora> listAllProductora() {
        return repository.findAll();
    }

    @Override
    public Productora saveProductora(Productora productora) {
        return repository.save(productora);
    }

    @Override
    public Productora getProductoraById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public Productora updateProductora(Productora productora) {
        return repository.save(productora);
    }

    @Override
    public void deleteProductora(Long id) {
            repository.deleteById(id);
    }
}
