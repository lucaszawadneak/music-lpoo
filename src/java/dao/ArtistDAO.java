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
import java.util.List;/**
 *
 * @author lucas
 */
public class ArtistDAO implements DAO<Artist>{
    
    private static final String INSERT = "";
    private static final String FIND_PAGINATED = "";
    private static final String FIND_ONE = "";
    
    private Connection con = null;
    
    public ArtistDAO(Connection con) throws Exception{
        if(con == null){
            throw new Exception("Conn null");
        }
        this.con = con;
    }

    @Override
    public Artist find(String identifier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Artist> findPaginated() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Artist t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
