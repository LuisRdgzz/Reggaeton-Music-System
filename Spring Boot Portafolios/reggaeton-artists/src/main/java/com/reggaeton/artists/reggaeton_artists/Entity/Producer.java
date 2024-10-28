package com.reggaeton.artists.reggaeton_artists.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Producer {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String alias;
     private String nacionality;
     private Integer yearsOfExperience;

     @ManyToOne
    @JoinColumn(name = "productora_id")
    private Productora productora;

     @ManyToMany(mappedBy = "producers")
    private List<Song> songsProduced = new ArrayList<>();

    public Producer() {
    }

    public Producer(String alias, String nacionality, Integer yearsOfExperience, Productora productora) {
        this.alias = alias;
        this.nacionality = nacionality;
        this.yearsOfExperience = yearsOfExperience;
        this.productora = productora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Productora getProductora() {
        return productora;
    }

    public void setProductora(Productora productora) {
        this.productora = productora;
    }

    public List<Song> getSongsProduced() {
        return songsProduced;
    }

    public void setSongsProduced(List<Song> songsProduced) {
        this.songsProduced = songsProduced;
    }
}
