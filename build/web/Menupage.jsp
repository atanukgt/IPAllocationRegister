<%-- 
    Document   : Menupage
    Created on : Jun 20, 2017, 2:21:14 PM
    Author     : Sagar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <title>Search Menu</title>
    </head>
    
    <link rel="stylesheet" href="bootstrap.css">
    <script src="bootstrap.js"></script>
    <script src="j-query.js"></script>

    <%--<link rel="stylesheet" href="newcss.css" type="text/css"/>--%>
      
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
    <br><br>
    
    <div class="container">
        <div class="jumbotron" style="background-color:#85929E" >
            <h1>IP Allocation Register</h1>
            <p>Welcome to the HomePage of IP Alocation Register<br></p>
        </div>
    </div>


    <div class="container">
        <div class="col">
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <a href="DataServlet"><p align="center" class="text-white"> Allocated IP Report </p> </a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                       <a href="existingreport"><p align="center" class="text-white">  Expired IP Allocations Report </p> </a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                       <a href="addcheck.jsp"><p align="center" class="text-white"> Add New IP Allocation </p> </a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <a href="SearchOption.jsp"><p align="center" class="text-white"> Search OR Sort </p> </a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <a href="newformat.jsp"><p align="center" class="text-white"> Shift IP / Expire IP </p> </a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <a href="Update.jsp"><p align="center" class="text-white"> Update Allocations </p> </a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-danger text-white">
                    <div class="card-body">
                        <a href="Deletedetails.jsp"><p align="center" class="text-white"> Delete Allocated IP </p> </a>
                    </div>
                </div>
                <br>
            </div>
        </div>
        <br>
    </div>
    <div class="container-fluid">
        <footer align="center" class="btn-secondary">Copyright &copy; NIC,KAILASAHAR</footer>
    </div>
    
</body>
</html>
