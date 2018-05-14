<%-- 
    Document   : newcheckfile
    Created on : 19 Dec, 2017, 8:59:36 PM
    Author     : Souvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 10000);

  if(session.getAttribute("email")==null)
      response.sendRedirect("loginpage.jsp");
  else
  {
  
    String name = (String) session.getAttribute("email");
    //out.print("Welcome " + name + ", to Search for Details Page");
  }

  %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Details By Windows Genuinity </title>
    </head>
    
    <link rel="stylesheet" href="#">

  
      <link rel="stylesheet" href="css/newcss.css">
      <link rel="stylesheet" href="newcss.css" type="text/css"/>
    
    <div class="container">

<header>
   <h1>IP Allocation Register</h1>
</header>
  
<nav>
  <ul>
      <li>Links</li>
      <br>
    <li><a href="DataServlet"> Show All Details</a></li>
    <li><a href="existingreport">Show Expired Allocations</a></li>
    <li><a href="addcheck.jsp">Add Details</a></li>
    <li><a href="SearchOption.jsp"> Search</a></li>
    <li><a href="Update.jsp">Update</a></li>
    <li><a href="Deletedetails.jsp">Delete</a></li>    
    
  </ul>
</nav>

<article>
  <h1 align="center">Search Details By Windows Genuinity </h1>
  <br>
   
        <FORM ACTION="windowscheck" METHOD="post">
             <INPUT TYPE="radio" NAME="radios" VALUE="radio1" CHECKED>
             Yes
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="radio2">
             No
            <BR>
            <INPUT TYPE="submit" VALUE="Submit">
        </FORM>
 </article>

<footer>Copyright &copy; NIC,KAILASAHAR</footer>

</div>

</html>
