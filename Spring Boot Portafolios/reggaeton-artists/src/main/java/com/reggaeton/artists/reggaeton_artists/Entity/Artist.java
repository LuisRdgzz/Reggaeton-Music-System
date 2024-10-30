package com.reggaeton.artists.reggaeton_artists.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] img;



    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String  countryOfOrigin;
    private Integer yearsActive;

    @Lob
    private String biography;

    @OneToMany(mappedBy = "artist" , cascade = CascadeType.ALL)
    private List<Album> albumes = new ArrayList<>();

    public Artist() {
    }

    public Artist(byte[] img, String name, Date birthDate, String countryOfOrigin, Integer yearsActive, String biography) {
        this.img = img;
        this.name = name;
        this.birthDate = birthDate;
        this.countryOfOrigin = countryOfOrigin;
        this.yearsActive = yearsActive;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getImgBase64(){
        if(img != null){
            return Base64.getEncoder().encodeToString(img);
        }
        return null;
    }
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Integer getYearsActive() {
        return yearsActive;
    }

    public void setYearsActive(Integer yearsActive) {
        this.yearsActive = yearsActive;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }
}
