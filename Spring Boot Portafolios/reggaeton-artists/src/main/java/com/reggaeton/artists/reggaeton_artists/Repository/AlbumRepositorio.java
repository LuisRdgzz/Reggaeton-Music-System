package com.reggaeton.artists.reggaeton_artists.Repository;

import com.reggaeton.artists.reggaeton_artists.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AlbumRepositorio extends JpaRepository<Album , Long> {
    @Query("SELECT ar.name, al.title, al.genre, al.releaseDate " +
            "FROM Album al " +
            "JOIN al.artist ar")
    List<Object[]> findAllAlbumArtist();

}
