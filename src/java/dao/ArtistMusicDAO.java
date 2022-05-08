/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Artist;
import beans.Music;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class ArtistMusicDAO {
    
    private static final String INSERT = "INSERT INTO artistmusic (musicid,artistaid) VALUES (?,?)";
    private static final String FIND_MUSIC_ARTISTS = "SELECT * FROM artista WHERE id = ?";
    
    private Connection con = null;
    
    public ArtistMusicDAO(Connection con) throws Exception{
        if(con == null){
            throw new Exception("Conn null");
        }
        this.con = con;
    }
    
    public void insert(Integer music_id, Integer artist_id) throws Exception {
        try{
            PreparedStatement ps = this.con.prepareStatement(INSERT);
            ps.setInt(1,music_id);
            ps.setInt(2,artist_id);
            
            ps.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    
    public ArrayList<Artist> findMusicAuthors(Integer music_id) throws Exception{
        String sql = "SELECT * FROM artistmusic am "
                + "INNER JOIN artista a ON a.id = am.artistaid "
                + "WHERE am.musicid = ?";
        ArrayList<Artist> list = new ArrayList<>();;
        try{
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setInt(1,music_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Artist a = new Artist();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setPais(rs.getString("pais"));
                a.setDescricao(rs.getString("descricao"));
                System.out.print(rs.getInt("id"));
                list.add(a);
            }
            return list;
        } catch (Exception e){
            System.out.println(e);
            throw e;
        }
    }
    
}
