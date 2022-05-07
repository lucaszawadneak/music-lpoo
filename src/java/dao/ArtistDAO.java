/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Artist;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;/**
 *
 * @author lucas
 */
public class ArtistDAO implements DAO<Artist>{
    
    private static final String INSERT = "INSERT INTO artista (nome,pais,descricao) VALUES (?,?,?)";
//    private static final String FIND_PAGINATED = "SELECT * FROM artista";
    private static final String FIND_ONE = "SELECT * FROM artista WHERE id = ?";
    private static final String SEARCH = "SELECT * FROM artista WHERE nome LIKE ?";
    
    private Connection con = null;
    
    public ArtistDAO(Connection con) throws Exception{
        if(con == null){
            throw new Exception("Conn null");
        }
        this.con = con;
    }

    @Override
    public Artist find(Integer identifier) throws Exception {
        try{
            PreparedStatement ps = this.con.prepareStatement(FIND_ONE);
            ps.setInt(1,identifier);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Artist a = new Artist();
                a.setId(Integer.parseInt(rs.getString("id")));
                a.setNome(rs.getString("nome"));
                a.setPais(rs.getString("pais"));
                a.setDescricao(rs.getString("descricao"));
                return a;
            }
        } catch (Exception e){
            throw e;
        }
        return null;
    }

    @Override
    public void insert(Artist a) throws Exception {
        try{
            PreparedStatement ps = this.con.prepareStatement(INSERT);
            ps.setString(1,a.getNome());
            ps.setString(2,a.getPais());
            ps.setString(3,a.getDescricao());
            
            ps.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    
    public ArrayList<Artist> search(String search) throws Exception {
        ArrayList<Artist> artistas = new ArrayList<>();
        try{
            PreparedStatement ps = this.con.prepareStatement(SEARCH);
            ps.setString(1,"%" + search + "%");
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Artist a = new Artist();
                a.setId(Integer.parseInt(rs.getString("id")));
                a.setNome(rs.getString("nome"));
                a.setPais(rs.getString("pais"));
                a.setDescricao(rs.getString("descricao"));
                artistas.add(a);
            }
            return artistas;
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
    
    public ArrayList<Artist> getMusicArtists(Integer music_id) throws Exception{
        String sql = "SELECT * FROM artistmusic am "
                + "INNER JOIN music m ON m.id=? "
                + "WHERE am.musicId = ?";
        ArrayList<Artist> list = new ArrayList<>();;
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1,music_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Artist a = new Artist();
                a.setId(Integer.parseInt(rs.getString("id")));
                a.setNome(rs.getString("nome"));
                a.setPais(rs.getString("pais"));
                a.setDescricao(rs.getString("descricao"));
                list.add(a);
            }
            return list;
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
    
}
