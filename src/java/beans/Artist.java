/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
public class Artist implements Serializable {
    private Integer id;
    private String nome;
    private String pais;
    private String descricao;

    public Artist(Integer id, String nome, String pais, String descricao) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
        this.descricao = descricao;
    }
    
    public Artist(String nome, String pais, String descricao) {
        this.nome = nome;
        this.pais = pais;
        this.descricao = descricao;
    }
    
    public Artist(Integer id) {
        this.id = id;
    }
    
    public Artist() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
