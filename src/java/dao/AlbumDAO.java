/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
public class AlbumDAO implements DAO<Album> {
    private static final String INSERT = "INSERT INTO album (nome,ano,visualizacoes) VALUES (?,?,?)";
    private static final String FIND_ONE = "SELECT * FROM album WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM album where nome = ?";
    private static final String SEARCH = "SELECT * FROM album WHERE nome LIKE ?";
    private Connection con = null;
    
    public AlbumDAO(Connection con) throws Exception{
        if(con == null){
            throw new Exception("Conn null");
        }
        this.con = con;
    }
    public ArrayList<Album> search(String search) throws Exception {
        ArrayList<Album> albuns = new ArrayList<>();
        try{
            PreparedStatement ps = this.con.prepareStatement(SEARCH);
            ps.setString(1,"%" + search + "%"); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Album a = new Album();
                a.setId(Integer.parseInt(rs.getString("id")));
                a.setNome(rs.getString("nome"));
                a.setAno(Integer.parseInt(rs.getString("ano")));
                albuns.add(a);
            }
            return albuns;
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
    public Album findByName(String nome) throws Exception {
    try{
       PreparedStatement ps = this.con.prepareStatement(FIND_BY_NAME);
       ps.setString(1, nome);
       ResultSet rs = ps.executeQuery();
       while(rs.next()){
            Album a = new Album();
            a.setId(Integer.parseInt(rs.getString("id")));
            a.setNome(rs.getString("nome"));
            a.setAno(Integer.parseInt(rs.getString("ano")));
            return a;
       }
    }catch (Exception e){
            throw e;
        }
        return null;
    }   
    @Override
    public Album find(Integer identifier) throws Exception {
    try{
            PreparedStatement ps = this.con.prepareStatement(FIND_ONE);
            ps.setInt(1,identifier);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Album a = new Album();
                a.setId(Integer.parseInt(rs.getString("id")));
                a.setNome(rs.getString("nome"));
                a.setAno(Integer.parseInt(rs.getString("ano")));
                return a;
            }
        } catch (Exception e){
            throw e;
        }
        return null;
    }   
    @Override
    public void insert(Album a) throws Exception {
        
        try{
            PreparedStatement ps = this.con.prepareStatement(INSERT);
            ps.setString(1,a.getNome());
            ps.setInt(2,a.getAno()); 
            ps.setInt(3,0);
            ps.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    
}
