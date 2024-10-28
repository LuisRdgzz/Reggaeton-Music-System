package com.reggaeton.artists.reggaeton_artists.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer duration;

    @ManyToOne // Cambiado a ManyToOne para reflejar que muchas canciones pueden pertenecer a un álbum
    @JoinColumn(name = "album_id") // Nombre de la columna en la tabla de canciones
    private Album album; // Propiedad que representa la relación inversa

    @ManyToMany
    @JoinTable(
            name = "song_colaboration",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> colaboration = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "song_producer",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id")
    )
    private List<Producer> producers = new ArrayList<>();

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Artist> getColaboration() {
        return colaboration;
    }

    public void setColaboration(List<Artist> colaboration) {
        this.colaboration = colaboration;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }
}
