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
    <title>Update Details </title>
</head>
    

<link rel="stylesheet" type="text/css" href="bootstrap.css">

<body onload='document.form2.ipaddress.focus()'>

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
    <h1 class="display-4">Sort by IP Address</h1>
  </div>
</div>  

<br><br>

<div class="container">
    <form action="searchengine" name="form2" method="POST">
        <div class="form-group">
            <label>IP Address:- </label>
            <input type="text" name="ipaddress" onsubmit="return ValidateIPaddressSearch()" class="form-control" placeholder="10.36.137.3">
            <small id="emailHelp" class="form-text text-muted">Enter the Unique ID Here.</small>
            
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
        
<script type="text/javascript" src="j-query.js"></script>
<script type="text/javascript" src="bootstrap.js"></script>
<script src="ipaddress-validationSearch.js"></script>
</body>
    
</html>

