package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
public class Album implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nome;   
    private int ano;
    
    public Album(){
        
    }
    public Album(String nomePassado,int anoPassado){
        this.nome = nomePassado;
        this.ano = anoPassado;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }
    
}
