/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
            Leonardo Xavier da Silva Moraes GRR20204488
            Lucas Cassilha Zawadneak GRR20200141
            Ludimilla Krautzuk GRR20204467
 */
public class AlbumDAO implements DAO<Album> {
    private static final String INSERT = "INSERT INTO album (nome,ano) VALUES (?,?)";

    
    private Connection con = null;
    
    public AlbumDAO(Connection con) throws Exception{
        if(con == null){
            throw new Exception("Conn null");
        }
        this.con = con;
    }
    @Override
    public Album find(Integer identifier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Album a) throws Exception {
        
        try{
            PreparedStatement ps = this.con.prepareStatement(INSERT);
            ps.setString(1,a.getNome());
            ps.setInt(2,a.getAno());  
            ps.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    
}
