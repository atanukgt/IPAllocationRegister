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
 * @author Souvik
 */
@WebServlet(name = "addipcheck44", urlPatterns = {"/addipcheck44"})
public class addipcheck44 extends HttpServlet {

    
String ipaddress;
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
int id=0;
int reply;
    
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
            
            String ipaddress2=(String)request.getParameter("ipaddress2");
             
            if(ipaddress2.equals(""))
            {   
                JOptionPane.showMessageDialog(null, "field cannot be empty");
                response.sendRedirect("addcheck.jsp");
                return;
            }
            else{
            
try       
    {                  

Connection conn=ConnectionManager.getConnection();
        
Statement stmt=conn.createStatement();
response.setContentType("text/html");

stmt.executeQuery("select * from dataentry;");
ResultSet rs= stmt.getResultSet();


while(rs.next()){
                ipaddress=(String)rs.getString("ipaddress");
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
                id=rs.getInt("id");
                
                if(ipaddress2.equals(ipaddress))
            {
        reply = JOptionPane.showConfirmDialog(null, "This IP already Exists.. Do you Want to enter a new details for this assinged IP?", "Select", JOptionPane.YES_NO_OPTION );
        
        if ( reply == JOptionPane.YES_OPTION ) 
        {
        
        JOptionPane.showMessageDialog(null, "Old Assingnee Details Is shifted to Expired Data Report Page..!");
        String check=(String)ipaddress2;
             
 try       
    {    

Class.forName("org.postgresql.Driver");
//Connection con2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sdc","postgres","nic");              
//Connection con3 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sdc","postgres","nic");              

Connection con2=ConnectionManager.getConnection();
Connection con3=ConnectionManager.getConnection();

Statement stmt2=con2.createStatement(); 
Statement stmt3=con3.createStatement();

int i = stmt2.executeUpdate("insert into expiredata values('"+check+"', '"+fname+"', '"+lname+"', '"+designation+"',  '"+email+"', '"+mobile+"', '"+location+"', '"+adate+"',  '"+edate+"', '"+mac+"',  '"+antivirus+"',  '"+windows+"', '"+id+"', '"+winversion+"');");              
int i2 = stmt3.executeUpdate("delete from dataentry where ipaddress='"+check+"' ;");

if(i>0 && i2>0)                
{
    JOptionPane.showMessageDialog(null, "Now you can add New User in this IP.");
    //response.sendRedirect("AddDetails.jsp");
    request.setAttribute("ipaddress",ipaddress2);
    RequestDispatcher dispatcher = request.getRequestDispatcher("AddDetails.jsp");
    dispatcher.forward(request,response);
}              
else                
{
    JOptionPane.showMessageDialog(null, "Insert Unsuccessfull.");
    response.sendRedirect("addcheck.jsp");
}
                stmt2.close();
                con2.close();
                con3.close();
                stmt3.close();
    }catch(Exception e)        
{          out.println(e);               
 }
        
        }
        
        
        if (reply == JOptionPane.NO_OPTION) 
        {
           JOptionPane.showMessageDialog(null, "Retry with Other IP");
           response.sendRedirect("addcheck.jsp");
           //return;
           //remove(reply);
        }
        
    }
}              
            if(!ipaddress.equals(ipaddress2))
                {
                    Boolean sb=(!ipaddress2.equals(ipaddress));
                    if(sb==true)
                    {
                    request.setAttribute("ipaddress",ipaddress2);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("AddDetails.jsp");
                    dispatcher.forward(request,response);
                    }
                    else
                    {
                        response.sendRedirect("addcheck.jsp");
                    //response.sendRedirect("AddDetails.jsp");   
                    
                    }
                }

                rs.close ();
                stmt.close ();

    }catch(Exception e)        
{          out.println(e);               
 }
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addipcheck44</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addipcheck44 at " + request.getContextPath() + "</h1>");
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
