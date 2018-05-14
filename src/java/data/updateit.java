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
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "updateit", urlPatterns = {"/updateit"})
public class updateit extends HttpServlet {

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
           
            
            String check=request.getParameter("id");
            if(check.equals(""))
            {   
                JOptionPane.showMessageDialog(null, "field cannot be empty");
                response.sendRedirect("Update.jsp");
                return;
            }
            
            int id=Integer.parseInt(request.getParameter("id"));
            
            try       
    {    

//Class.forName("org.postgresql.Driver");
//Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nic","postgres","nic");              

        Connection con=ConnectionManager.getConnection();
        Statement stmt=con.createStatement();
response.setContentType("text/html");

stmt.executeQuery("select * from dataentry where id='"+id+"';");
ResultSet rs= stmt.getResultSet();

String ipaddress=null;
String fname=null;
String lname=null;
String designation=null;
String email=null;
String mobile=null;
String location=null;
String mac=null;
String adate=null;
String edate=null;
String antivirus=null;
String windows=null;
String winversion=null;

while(rs.next()){
            ipaddress=rs.getString("ipaddress");
            fname=rs.getString("fname");
            lname=rs.getString("lname");
            designation=rs.getString("designation");
            email=rs.getString("email");
            mobile=rs.getString("mobile");
            location=rs.getString("location");
            mac=rs.getString("mac");
            adate=rs.getString("adate");
            edate=rs.getString("edate");
            antivirus=rs.getString("antivirus");
            windows=rs.getString("windows");
            winversion=rs.getString("winversion");
            
}
                rs.close ();

                stmt.close ();
            request.setAttribute("ipaddress",ipaddress);
            request.setAttribute("fname",fname);
            request.setAttribute("lname",lname);
            request.setAttribute("designation",designation);
            request.setAttribute("email",email);
            request.setAttribute("mobile",mobile);
            request.setAttribute("location",location);
            request.setAttribute("mac",mac);
            request.setAttribute("adate",adate);
            request.setAttribute("edate",edate);
            request.setAttribute("antivirus",antivirus);
            request.setAttribute("windows",windows);
            request.setAttribute("winversion",winversion);
            request.setAttribute("id",id);
                
    RequestDispatcher dispatcher = request.getRequestDispatcher("updateview.jsp");
    dispatcher.forward(request,response);

}catch(Exception e)        
{          out.println(e);               
 }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateit at " + request.getContextPath() + "</h1>");
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
