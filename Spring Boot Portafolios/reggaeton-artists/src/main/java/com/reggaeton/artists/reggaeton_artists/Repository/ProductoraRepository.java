package com.reggaeton.artists.reggaeton_artists.Repository;

import com.reggaeton.artists.reggaeton_artists.Entity.Productora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoraRepository extends JpaRepository<Productora , Long> {



}
