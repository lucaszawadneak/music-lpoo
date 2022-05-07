/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
public class Music {
    private int id;
    private String title;
    private String duration;
    private String lyrics;
    private Album album;
    private String Generos;
    private Artist artista;
    private Link links;
    private int visualizacoes;
    
    public Music() {
    }

    public Music(String title, String duration, String lyrics, Album album, String Generos, Artist artista, Link links, int visualizacoes) {
        this.title = title;
        this.duration = duration;
        this.lyrics = lyrics;
        this.album = album;
        this.Generos = Generos;
        this.artista = artista;
        this.links = links;
        this.visualizacoes = visualizacoes;
    }

    public Music(int id, String title, String duration, String lyrics, Album album, String Generos, Artist artista, Link links, int visualizacoes) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.lyrics = lyrics;
        this.album = album;
        this.Generos = Generos;
        this.artista = artista;
        this.links = links;
        this.visualizacoes = visualizacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getGeneros() {
        return Generos;
    }

    public void setGeneros(String Generos) {
        this.Generos = Generos;
    }


    public Artist getArtista() {
        return artista;
    }

    public void setArtista(Artist artista) {
        this.artista = artista;
    }

    public Link getLinks() {
        return links;
    }

    public void setLinks(Link links) {
        this.links = links;
    }

    public int getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(int visualizacoes) {
        this.visualizacoes = visualizacoes;
    }
    
}
