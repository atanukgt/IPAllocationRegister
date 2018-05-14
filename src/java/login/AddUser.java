/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {

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
            
            String username=request.getParameter("UserName");
            String password=request.getParameter("password");
            String masterpassword=request.getParameter("masterpassword");
            
            if(username.equals("") && password.equals("") && masterpassword.equals("") )
            {   
                JOptionPane.showMessageDialog(null, "field cannot be empty");
                response.sendRedirect("register.jsp");
                return;
            }
            
            try       
    {    

Class.forName("org.postgresql.Driver");
Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nic","postgres","nic");              
Statement stmt=con.createStatement();
response.setContentType("text/html");

stmt.executeQuery("select * from masterpassword;");
ResultSet rs= stmt.getResultSet();
String ms = null;
while(rs.next())
{
    ms=rs.getString("masterpass");
}

if(!ms.equals(masterpassword))
{
                JOptionPane.showMessageDialog(null, "Master Password Doesnot Match");
                response.sendRedirect("register.jsp");
                return;
}

}catch(Exception e)        
{          out.println(e);               
 }
            
            
try       
    {    

Class.forName("org.postgresql.Driver");
Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sdc","postgres","sdc");              
Statement stmt=con.createStatement();              

int i = stmt.executeUpdate("insert into login values('"+username+"', '"+password+"')");              
if(i>0)                
{
    JOptionPane.showMessageDialog(null, "Account Created successfully.");
    response.sendRedirect("loginpage.jsp");
}              
else                
{
    JOptionPane.showMessageDialog(null, "Error.");
    response.sendRedirect("loginpage.jsp");
}




}catch(Exception e)        
{          out.println(e);               
 }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddUser at " + request.getContextPath() + "</h1>");
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
