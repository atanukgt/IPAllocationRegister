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
@WebServlet(name = "DeleteDetails", urlPatterns = {"/DeleteDetails"})
public class DeleteDetails extends HttpServlet {

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
            
            String check=request.getParameter("id");
            if(check.equals(""))
            {   
                JOptionPane.showMessageDialog(null, "field cannot be empty");
                response.sendRedirect("Update.jsp");
                return;
            }
            
            int id=Integer.parseInt(request.getParameter("id"));
            int reply = JOptionPane.showConfirmDialog( null, "Do you Want to Proceed", "select an option", JOptionPane.YES_NO_CANCEL_OPTION);
           
            if (reply == JOptionPane.YES_OPTION) 
    { 
            try{

	 //loading drivers for psql
         Class.forName("org.postgresql.Driver");
         //creating connection with the database 
         //Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/nic","postgres","nic");

         Connection conn=ConnectionManager.getConnection();
         
         response.setContentType("text/html");
         Statement st=conn.createStatement();
            

int i = st.executeUpdate("delete from dataentry where id='"+id+"' ;");
if(i>0)
{
    JOptionPane.showMessageDialog(null, "Row has been deleted successfully.");
    response.sendRedirect("Deletedetails.jsp");
}


else
{
    JOptionPane.showMessageDialog(null, "Error Occured");
    response.sendRedirect("Deletedetails.jsp");
}
         
      }catch(Exception e)
      {

        System.out.println("Exception is ;"+e);

      }
    }
            else {
           JOptionPane.showMessageDialog(null, "Error");
           response.sendRedirect("Deletedetails.jsp");
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteDetails at " + request.getContextPath() + "</h1>");
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
