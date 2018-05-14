/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sagar
 */
@WebServlet(name = "existingreport", urlPatterns = {"/existingreport"})
public class existingreport extends HttpServlet {

    
    
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
            /* TODO output your page here. You may use following sample code. */
            
            try{

	 //loading drivers for mysql
         //Class.forName("org.postgresql.Driver");

 	 //creating connection with the database 
         //Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/nic","postgres","nic");

         Connection conn=ConnectionManager.getConnection();
         ResultSet rs;

         response.setContentType("text/html");

         List dataList= new ArrayList();
            
            
            String sql = "select * from expiredata order by ipaddress ;";

            Statement stmt = conn.createStatement();

            stmt.executeQuery(sql);

            rs = stmt.getResultSet();

                 while (rs.next()){

                //Add records into data list

                dataList.add(rs.getString("ipaddress"));
                dataList.add(rs.getString("fname"));
                dataList.add(rs.getString("lname"));
                dataList.add(rs.getString("designation"));
                dataList.add(rs.getString("email"));
                dataList.add(rs.getString("mobile"));
                dataList.add(rs.getString("location"));
                dataList.add(rs.getString("adate"));
                dataList.add(rs.getString("edate"));
                dataList.add(rs.getString("mac"));
                dataList.add(rs.getString("antivirus"));
                dataList.add(rs.getString("windows"));
                dataList.add(rs.getString("winversion"));
                dataList.add(rs.getInt("id"));
                

                }

                rs.close ();

                stmt.close ();
         
        request.setAttribute("data", dataList);
        request.setAttribute("reportype", "Expired Report");
        request.setAttribute("checkby2", "Table");
        
      }catch(Exception e)
      {

        System.out.println("Exception is ;"+e);

      }

  

  //Disptching request
    String page="expiredSearchResult.jsp";
    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
    
    if (dispatcher != null){

  dispatcher.forward(request, response);

  } 
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<a href='Update.jsp'>Update");
            out.println("</a>");
            
            out.println("<h1>Servlet DataServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
