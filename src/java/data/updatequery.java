/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
/**
 *
 * @author Sagar
 */
@WebServlet(name = "updatequery", urlPatterns = {"/updatequery"})
public class updatequery extends HttpServlet {

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
            
            String ipaddress=request.getParameter("ipaddress");
            String fname=request.getParameter("fname");
            String lname=request.getParameter("lname");
            String designation=request.getParameter("designation");
            String email=request.getParameter("email");
            String mobile=request.getParameter("mobile");
            String location=request.getParameter("location");
            String mac=request.getParameter("mac");
            String adate=request.getParameter("adate");
            String edate=request.getParameter("edate");
            String antivirus=null;
            String windows=null;
            String winversion=request.getParameter("osversion");
            int id=Integer.parseInt(request.getParameter("id"));
                        if(request.getParameter("radios") != null) {
                if(request.getParameter("radios").equals("radio1")) {
                    antivirus="yes";
                }
                else {
                    antivirus="no";
                }
                
            }
            
            if(request.getParameter("radioswin") != null) {
                if(request.getParameter("radioswin").equals("radiowin1")) {
                    windows="yes";
                }
                else {
                    windows="no";
                }
                
            }
                    
            
    try       
    {    

//Class.forName("org.postgresql.Driver");
//Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nic","postgres","nic");               

        Connection con=ConnectionManager.getConnection();
        PreparedStatement ps;
 
 ps = con.prepareStatement("update dataentry set fname='"+fname+"' ,lname='"+lname+"' ,designation='"+designation+"' ,email='"+email+"' ,mobile='"+mobile+"' ,location= '"+location+"',adate='"+adate+"' ,edate='"+edate+"' ,mac='"+mac+"' ,antivirus= '"+antivirus+"',windows='"+windows+"', winversion='"+winversion+"' where id='"+id+"' ;");
 int i=ps.executeUpdate();
 ps.close();

if(i!=0)
    {
    JOptionPane.showMessageDialog(null, "Details has been Updated successfully.");
    response.sendRedirect("DataServlet");
}
else
    {
    JOptionPane.showMessageDialog(null, "Error Occured.");
    response.sendRedirect("Update.jsp");
}

}catch(Exception e)        
{          out.println(e);               
 }    
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dataentry</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<a href='Menupage.jsp'>Go back to Menu");
            out.println("</a>");
            
            out.println("<h1>Servlet dataentry at " + request.getContextPath() + "</h1>");
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
