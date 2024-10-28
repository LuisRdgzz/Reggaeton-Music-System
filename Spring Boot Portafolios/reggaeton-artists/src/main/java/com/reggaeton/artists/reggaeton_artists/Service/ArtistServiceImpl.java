package com.reggaeton.artists.reggaeton_artists.Service;

import com.reggaeton.artists.reggaeton_artists.Entity.Artist;
import com.reggaeton.artists.reggaeton_artists.Repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {


    @Autowired
    private ArtistRepository repository;

    @Override
    public List<Artist> listAllArtist() {
        return repository.findAll();
    }
}
