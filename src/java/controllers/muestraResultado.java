/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Triangulo;

/**
 *
 * @author rogev
 */
@WebServlet(name = "muestraResultado", urlPatterns = {"/muestraResultado"})
public class muestraResultado extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            if(request.getAttribute("error") != null){
                request.setAttribute("error", 1);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                double base = Double.parseDouble(request.getParameter("base"));
                double altura = Double.parseDouble(request.getParameter("altura"));
                Triangulo triangulo = new Triangulo(base,altura);

                Cookie ck = new Cookie("altura",request.getParameter("altura"));
                response.addCookie(ck);
                ck = new Cookie("base",request.getParameter("base")); 
                response.addCookie(ck);
                ck = new Cookie("area",triangulo.getArea().toString()); 
                response.addCookie(ck);
                ck = new Cookie("perimetro",triangulo.getPerimetro().toString());
                response.addCookie(ck);

                request.setAttribute("triangulo", triangulo);
                request.getRequestDispatcher("resultado.jsp").forward(request, response);
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
