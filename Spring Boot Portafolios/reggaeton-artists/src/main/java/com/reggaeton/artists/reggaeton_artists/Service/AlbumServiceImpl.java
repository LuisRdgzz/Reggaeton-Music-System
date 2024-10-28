package com.reggaeton.artists.reggaeton_artists.Service;

import com.reggaeton.artists.reggaeton_artists.Entity.Album;
import com.reggaeton.artists.reggaeton_artists.Repository.AlbumRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepositorio albumRepositorio;

    @Override
    public List<Object[]> getAllAlbumArtist() {
        return albumRepositorio.findAllAlbumArtist();
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepositorio.findById(id).get();
    }

    @Override
    public Album SaveAlbum(Album album) {
        return albumRepositorio.save(album);
    }

    @Override
    public Album UpdateAlbum(Album album) {
        return albumRepositorio.save(album);
    }

    @Override
    public void DeleteAlbum(Long id) {
            albumRepositorio.deleteById(id);
    }
}
