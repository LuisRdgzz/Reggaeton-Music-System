package com.reggaeton.artists.reggaeton_artists.Service;

import com.reggaeton.artists.reggaeton_artists.Entity.Productora;

import java.util.List;

public interface ProductoraService {

public List<Productora> listAllProductora();

public Productora saveProductora(Productora productora);

public Productora getProductoraById(Long id);

public Productora updateProductora(Productora productora);

public void deleteProductora(Long id);

}
