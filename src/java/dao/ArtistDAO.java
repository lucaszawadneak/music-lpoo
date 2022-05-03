/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Artist;

/**
 *
 * @author lucas
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;/**
 *
 * @author lucas
 */
public class ArtistDAO implements DAO<Artist>{
    
    private static final String INSERT = "INSERT INTO artista (nome,pais,descricao) VALUES (?,?,?)";
//    private static final String FIND_PAGINATED = "";
    private static final String FIND_ONE = "SELECT * FROM artista WHERE id = ?";
    
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
    public List<Artist> findPaginated() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
