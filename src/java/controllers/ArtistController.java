/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Artist;
import beans.Music;
import connection.ConnectionFactory;
import dao.ArtistDAO;
import dao.MusicDAO;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author lucas
 */
@WebServlet(name = "ArtistController", urlPatterns = {"/ArtistController"})
public class ArtistController extends HttpServlet {

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
        
        RequestDispatcher rd = request.getRequestDispatcher("/artist/index.jsp");
        
        String action = request.getParameter("action");
        ConnectionFactory conn = new ConnectionFactory();
        
        if("store".equals(action)){
            String nome = request.getParameter("nome");
            String pais = request.getParameter("pais");
            String descricao = request.getParameter("descricao");
            
            Artist a = new Artist(nome,pais, descricao);
            
            try{
                ArtistDAO aDAO = new ArtistDAO(conn.getConnection());
                aDAO.insert(a);
                    
                request.setAttribute("artista", a);
                
                rd.forward(request, response);
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Erro ao criar artista");
            }
            
        } else {
            String artistID = request.getParameter("id");
            String page = request.getParameter("page");
            String searchParam = request.getParameter("searchParam");
            
            System.out.println(searchParam);
            if(artistID == null) {
                response.sendRedirect("./index.jsp");
            }
            
            try{
                ArtistDAO aDAO = new ArtistDAO(conn.getConnection());
                Artist a = aDAO.find(Integer.parseInt(artistID));
                
                if(a == null){
                    response.sendRedirect("./index.jsp");
                }
                
                request.setAttribute("artista", a);
//                MusicDAO mDAO = new MusicDAO(conn.getConnection());
//               
//                Integer musicCount = mDAO.getArtistMusicCount(a.getId());
//                
//                request.setAttribute("musicCount", musicCount);
                Integer localPage = 0;
                if(page != null){
                    localPage = Integer.parseInt(page);
                }
//                ArrayList<Music> musicList = mDAO.findByArtistPaginated(a.getId(), localPage, null);
                
//                request.setAttribute("musicList", musicList);
                rd.forward(request, response);
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Erro ao buscar músicas");
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
