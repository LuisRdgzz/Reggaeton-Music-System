package com.reggaeton.artists.reggaeton_artists.Service;

import com.reggaeton.artists.reggaeton_artists.Entity.Album;

import java.util.List;

public interface AlbumService {

    List<Object[]> getAllAlbumArtist();

    public Album getAlbumById(Long id);

    public Album SaveAlbum(Album album);

    public Album UpdateAlbum(Album album);

    public void DeleteAlbum(Long id);

}
