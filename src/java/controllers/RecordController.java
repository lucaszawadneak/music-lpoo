/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Album;
import connection.ConnectionFactory;
import dao.AlbumDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @authors Gustavo Schwanka GRR20193748
 *          Leonardo Xavier da Silva Moraes GRR20204488
 *          Lucas Cassilha Zawadneak GRR20200141
 *          Ludimilla Krautzuk GRR20204467
 */
@WebServlet(name = "RecordController", urlPatterns = { "/RecordController" })
public class RecordController extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/album/index.jsp");
        String action = request.getParameter("action");
        ConnectionFactory conn = new ConnectionFactory();
        if ("store".equals(action)){
            try {
                Album al = new Album(request.getParameter("nome"),Integer.parseInt(request.getParameter("ano")));
                AlbumDAO alD = new AlbumDAO(conn.getConnection());
                alD.insert(al);
                request.setAttribute("album", al);
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erro ao criar album");
            }
        } else if ("search".equals(action)) {
            
        } else if ("update".equals(action)) {

        } else if ("delete".equals(action)){
            
        } else if ("show".equals(action)){
            
        }else {
             response.sendRedirect("./index.jsp");
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
