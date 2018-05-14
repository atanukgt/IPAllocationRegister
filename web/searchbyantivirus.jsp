<%-- 
    Document   : Update
    Created on : Jun 20, 2017, 3:15:39 PM
    Author     : Souvik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

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
    <title>Sort Details </title>
</head>
    

<link rel="stylesheet" type="text/css" href="bootstrap.css">

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
  <a class="navbar-brand text-white" href="#">NIC Tripura</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
          <a class="nav-link text-white" href="Menupage.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
          <a class="nav-link text-white" href="addcheck.jsp">Add IP</a>
      </li>
      <li class="nav-item">
          <a class="nav-link text-white" href="SearchOption.jsp">Sort Data</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled text-white" href="logout">Logout</a>
      </li>
    </ul>
  </div>
</nav>
    
<div class="jumbotron">
  <div class="container">
    <h1 class="display-4">Sort Details</h1>
  </div>
</div>  

<br><br>

<div class="container">
    <form action="antiviruscheck" method="POST">
        <div class="form-group">
            <label>Sort By Weather Antivirus Installed </label>
            <br>
            <INPUT TYPE="radio" NAME="radios" VALUE="radio1" CHECKED>
            Yes
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="radio2">
            No
            <br><br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
        
<script type="text/javascript" src="j-query.js"></script>
<script type="text/javascript" src="bootstrap.js"></script>
</body>
    
</html>
