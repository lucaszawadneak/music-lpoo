/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Album;
import beans.Artist;
import beans.Genero;
import beans.Link;
import beans.Music;
import connection.ConnectionFactory;
import dao.AlbumDAO;
import dao.ArtistDAO;
import dao.MusicDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo
 */
@WebServlet(name = "MusicController", urlPatterns = {"/MusicController"})
public class MusicController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("/music/index.jsp");
        
        String action = request.getParameter("action");
        ConnectionFactory conn = new ConnectionFactory();

        if("store".equals(action)){
            Link links = null;
            
            String nome = request.getParameter("nome");
            String artista = request.getParameter("artista");
            String duracao = request.getParameter("duracao");
            String letra = request.getParameter("letra");
            String generos = request.getParameter("genero");
            String linkSpotify = request.getParameter("link_spotify");
            String linkDeezer = request.getParameter("link_deezer");
            String linkApple = request.getParameter("link_apple");
            String album_id = request.getParameter("album_id");
            
         
            Genero genero = new Genero(0,"rock");
            if (linkSpotify == null){
                List<String> list = new ArrayList<>();
                list.add(linkApple);
                list.add(linkDeezer);
                List<String> types = new ArrayList<>();
                types.add("AppleMusic");
                types.add("Deezer");
                links = new Link(list,types);
            } else if (linkDeezer == null){
                List<String> list = new ArrayList<>();
                list.add(linkSpotify);
                list.add(linkApple);
                List<String> types = new ArrayList<>();
                types.add("Spotify");
                types.add("AppleMusic");
                links = new Link(list,types);
            } else if (linkApple == null){
                List<String> list = new ArrayList<>();
                list.add(linkSpotify);
                list.add(linkDeezer);
                List<String> types = new ArrayList<>();
                types.add("Spotify");
                types.add("Deezer");
                links = new Link(list,types);
            } else{
                links = new Link(linkSpotify, linkDeezer, linkApple);
            }
            
            String artist_id = request.getParameter("artist_id");
            
            System.out.println(artist_id);
            
            try{
                
                ArtistDAO artDAO = new ArtistDAO(conn.getConnection());
                MusicDAO mDAO = new MusicDAO(conn.getConnection());
                AlbumDAO albDAO = new AlbumDAO(conn.getConnection());
                
                Artist a = artDAO.find(Integer.parseInt(artist_id));
                
                Album album = null;
                
                if(album_id == null){
                    album = new Album(nome,2022);
                    
                    albDAO.insert(album);
                } else {
                    album = albDAO.find(Integer.parseInt(album_id));
                }
                
                Music m = new Music(letra, duracao, letra, album, generos, genero, a, links, 0);
                mDAO.insert(m);
                    
                request.setAttribute("musica", m);
                
                rd.forward(request, response);
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Erro ao criar musica");
            }
            
        } else if("search".equals(action)){
            request.setAttribute("musicas", new ArrayList<>());
            String searchParam = request.getParameter("searchParam");

            try{
                MusicDAO m = new MusicDAO(conn.getConnection());

                ArrayList<Music> artistas = m.search(searchParam);

                request.setAttribute("artistas", artistas);

                RequestDispatcher search = request.getRequestDispatcher("/artist/selecionarArtista.jsp");
                search.forward(request, response);
            
            } catch (Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
                    
        } else {
            String musicID = request.getParameter("id");
            
            if(musicID == null) {
                response.sendRedirect("./index.jsp");
            }
            
            try{
                MusicDAO mDAO = new MusicDAO(conn.getConnection());
                Music m = mDAO.find(Integer.parseInt(musicID));
                
                request.setAttribute("musica", m);

                rd.forward(request, response);
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Erro ao buscar música");
                System.out.println(e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
