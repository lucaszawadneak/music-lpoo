/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Album;
import beans.Artist;
import beans.Music;
import beans.Link;
import beans.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
public class MusicDAO implements DAO<Music> {
    private static final String INSERT = "INSERT INTO musica (titulo,duracao,idgenero,letra,visualizaoes,idalbum,spotify,deezer,applemusic) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String FIND_ONE = "";
    private static final String SEARCH = "SELECT * FROM music WHERE titulo LIKE ?";
    
    private Connection con = null;
    
    public MusicDAO(Connection con) throws Exception{
        if(con == null){
            throw new Exception("Conn null");
        }
        this.con = con;
    }
    
    @Override
    public Music find(Integer identifier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Music m) throws Exception {
        try{
            PreparedStatement ps = this.con.prepareStatement(INSERT);
            ps.setString(1,m.getTitle());
            ps.setString(2,m.getDuration());
            ps.setString(3,m.getGenero().getId());
            ps.setString(4,m.getLyrics());
            ps.setString(5,m.getVisualizacoes());
            ps.setString(6,m.getAlbum().getId());
//            ps.setString(7,m.getLinks().getLinkSpotify());
//            ps.setString(8,m.getLinks().getLinkDeezer());
//            ps.setString(9,m.getLinks().getLinkAppleMusic());
            
            ps.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    
    
    // BUSCA UMA LISTA DE MÚSICA COM PAGINAÇÃO
    // LIMIT 10 = LIMITA A BUSCA A 10 ITENS
    // OFFSET = pula a busca por x itens = paginação
    public ArrayList<Music> findByArtistPaginated(Integer artist_id,Integer page,String searchParam) throws Exception{
        Integer offset = page * 10;
        String sql = "SELECT * FROM artistmusic am "
                + "INNER JOIN musica m ON m.id = am.musicid "
                + "WHERE am.artistaid = ?";
        if(searchParam != null)
            sql += " AND m.title LIKE ?";
        sql += " LIMIT 10 OFFSET ?";
        ArrayList<Music> list = new ArrayList<>();;
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1,artist_id);
            if(searchParam != null){
                ps.setString(2,"%" + searchParam + "%");
                ps.setInt(3,offset);
            } else {
                ps.setInt(2,offset);   
            }
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Music m = new Music();
                m.setId(rs.getInt("id"));
                m.setTitle(rs.getString("titulo"));
                m.setArtista((Artist)rs.getObject("artist"));
                m.setDuration(rs.getString("duration"));
                m.setLyrics(rs.getString("lyrics"));
                m.setLinks((Link)rs.getObject("link"));
                m.setGenero((Genero)rs.getObject("genero"));
                m.setAlbum((Album)rs.getObject("album"));
                list.add(m);
            }
            return list;
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
    
    public Integer getArtistMusicCount(Integer artist_id) throws Exception{
        String sql = "SELECT COUNT(*) as total FROM artistmusic WHERE artistaid = ?";
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1,artist_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer total = rs.getInt("total");
                return total;
            }
            return 0;
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
    
    public ArrayList<Music> search(String search) throws Exception {
        ArrayList<Music> musicas = new ArrayList<>();
        try{
            PreparedStatement ps = this.con.prepareStatement(SEARCH);
            ps.setString(1,"%" + search + "%");
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
            }
            return musicas;
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
   
     
}
