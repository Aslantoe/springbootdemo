package com.example.manager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jack
 * @date 2018/4/13 0013 16:54
 */
public class Film implements Serializable{
    private Integer filmId;
    private String filmCnName;
    private String filmEnName;
    private String filmPoster;
    private String filmGallery;
    private String filmDirector;
    private String filmActor;
    private String filmGenre;
    private String filmCountry;
    private String filmLanguage;
    private Date releaseDate;
    private String filmMins;
    private String filmIntroduction;
    private Double filmScore;
    private String filmLink;

    public Film() {
    }

    public Film(Integer filmId, String filmCnName, String filmEnName, String filmPoster, String filmGallery, String filmDirector, String filmActor, String filmGenre, String filmCountry, String filmLanguage, Date releaseDate, String filmMins, String filmIntroduction, Double filmScore, String filmLink) {
        this.filmId = filmId;
        this.filmCnName = filmCnName;
        this.filmEnName = filmEnName;
        this.filmPoster = filmPoster;
        this.filmGallery = filmGallery;
        this.filmDirector = filmDirector;
        this.filmActor = filmActor;
        this.filmGenre = filmGenre;
        this.filmCountry = filmCountry;
        this.filmLanguage = filmLanguage;
        this.releaseDate = releaseDate;
        this.filmMins = filmMins;
        this.filmIntroduction = filmIntroduction;
        this.filmScore = filmScore;
        this.filmLink = filmLink;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmCnName() {
        return filmCnName;
    }

    public void setFilmCnName(String filmCnName) {
        this.filmCnName = filmCnName;
    }

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public String getFilmPoster() {
        return filmPoster;
    }

    public void setFilmPoster(String filmPoster) {
        this.filmPoster = filmPoster;
    }

    public String getFilmGallery() {
        return filmGallery;
    }

    public void setFilmGallery(String filmGallery) {
        this.filmGallery = filmGallery;
    }

    public String getFilmDirector() {
        return filmDirector;
    }

    public void setFilmDirector(String filmDirector) {
        this.filmDirector = filmDirector;
    }

    public String getFilmActor() {
        return filmActor;
    }

    public void setFilmActor(String filmActor) {
        this.filmActor = filmActor;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public String getFilmCountry() {
        return filmCountry;
    }

    public void setFilmCountry(String filmCountry) {
        this.filmCountry = filmCountry;
    }

    public String getFilmLanguage() {
        return filmLanguage;
    }

    public void setFilmLanguage(String filmLanguage) {
        this.filmLanguage = filmLanguage;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFilmMins() {
        return filmMins;
    }

    public void setFilmMins(String filmMins) {
        this.filmMins = filmMins;
    }

    public String getFilmIntroduction() {
        return filmIntroduction;
    }

    public void setFilmIntroduction(String filmIntroduction) {
        this.filmIntroduction = filmIntroduction;
    }

    public Double getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(Double filmScore) {
        this.filmScore = filmScore;
    }

    public String getFilmLink() {
        return filmLink;
    }

    public void setFilmLink(String filmLink) {
        this.filmLink = filmLink;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmCnName='" + filmCnName + '\'' +
                ", filmEnName='" + filmEnName + '\'' +
                ", filmPoster='" + filmPoster + '\'' +
                ", filmGallery='" + filmGallery + '\'' +
                ", filmDirector='" + filmDirector + '\'' +
                ", filmActor='" + filmActor + '\'' +
                ", filmGenre='" + filmGenre + '\'' +
                ", filmCountry='" + filmCountry + '\'' +
                ", filmLanguage='" + filmLanguage + '\'' +
                ", releaseDate=" + releaseDate +
                ", filmMins='" + filmMins + '\'' +
                ", filmIntroduction='" + filmIntroduction + '\'' +
                ", filmScore=" + filmScore +
                ", filmLink='" + filmLink + '\'' +
                '}';
    }
}
