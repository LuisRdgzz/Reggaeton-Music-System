package com.reggaeton.artists.reggaeton_artists.Service;

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
}
