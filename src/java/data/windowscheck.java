/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Souvik
 */
@WebServlet(name = "windowscheck", urlPatterns = {"/windowscheck"})
public class windowscheck extends HttpServlet {

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
            
            
            
            String name=null;
            String  checkby="Weather Genuine Oprating System";
            if(request.getParameter("radios") != null) {
                if(request.getParameter("radios").equals("radio1")) {
                    //out.println("Radio button 1 was selected.<BR>");
                    //request.setAttribute(name, "yes");
                    name="yes";
                }
                else {
                    //out.println("Radio button 1 was not selected.<BR>");
                    //request.setAttribute(name, "no");
                    name="no";
                }
                
            }
            
            try       
    {    

//Class.forName("org.postgresql.Driver");
//Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nic","postgres","nic");              

        Connection con=ConnectionManager.getConnection();
        Statement stmt=con.createStatement();
response.setContentType("text/html");

stmt.executeQuery("select * from dataentry where windows='"+name+"' ;");
ResultSet rs= stmt.getResultSet();

List dataList= new ArrayList();
int id;
while(rs.next()){
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
            request.setAttribute("data",dataList);
            request.setAttribute("reportype",name);
            request.setAttribute("checkby2",checkby);
            //request.setAttribute("reportype", "Windows Genuinity");
                
    RequestDispatcher dispatcher = request.getRequestDispatcher("searchresult.jsp");
    dispatcher.forward(request,response);

}catch(Exception e)        
{          out.println(e);               
 }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet windowscheck</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet windowscheck at " + request.getContextPath() + "</h1>");
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
