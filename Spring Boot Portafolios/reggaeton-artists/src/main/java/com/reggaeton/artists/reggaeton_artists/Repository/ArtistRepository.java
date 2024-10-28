package com.reggaeton.artists.reggaeton_artists.Repository;

import com.reggaeton.artists.reggaeton_artists.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
