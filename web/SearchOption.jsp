<%-- 
    Document   : SearchOption
    Created on : 27 Oct, 2017, 10:13:50 PM
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
        <title>Search Details By Different Catagory</title>
    </head>

    <link rel="stylesheet" href="bootstrap.css">
    <script src="bootstrap.js"></script>
    <script src="j-query.js"></script>
      
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
            <h1>Search OR Sort</h1>
        </div>
    </div>


    <div class="container">
        <div class="col">
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                       <a href="SearchDetails.jsp"><p align="center" class="text-white"s>By IP Address</p></a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                       <a href="searchbyname.jsp"><p align="center" class="text-white">By Name</p></a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                       <a href="searchbydesignation.jsp"><p align="center" class="text-white">By Designation</p></a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <a href="searchbylocation.jsp"><p align="center" class="text-white">By Location</p></a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <a href="searchbywindows.jsp"><p align="center" class="text-white">By Windows Genuinity</p></a>
                    </div>
                </div>
                <br>
            </div>
            <div class="col-lg-12">
                <div class="card bg-primary text-white">
                    <div class="card-body">
                        <a href="searchbyantivirus.jsp"><p align="center" class="text-white">By Antivirus Installed</p></a>
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

