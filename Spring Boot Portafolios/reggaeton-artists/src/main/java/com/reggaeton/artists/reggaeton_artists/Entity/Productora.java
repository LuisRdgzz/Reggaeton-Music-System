package com.reggaeton.artists.reggaeton_artists.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Productora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fundation;

    private String ubication;

    @OneToMany(mappedBy = "productora" , cascade = CascadeType.ALL)
    private List<Producer> producers = new ArrayList<>();

    public Productora() {
    }

    public Productora(String name, String brand, LocalDate fundation, String ubication) {
        this.name = name;
        this.brand = brand;
        this.fundation = fundation;
        this.ubication = ubication;
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getFundation() {
        return fundation;
    }

    public void setFundation(LocalDate fundation) {
        this.fundation = fundation;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }
}
