<%-- 
    Document   : AddDetails
    Created on : Jun 20, 2017, 2:18:54 PM
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
        <title>Add Details Page</title>
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
    <h1 class="display-4">Add New Allocation Details</h1>
  </div>
</div>      
    
<br><br>

<div class="container">
    <h3 align="center">Please Fill The Details</h3>
    <form action="dataentry" method="POST">
    <table class="table table-striped">
        
        <tr>
            <th scope="row">1</th>
            <td>IP Address:</td>
            <td><input type="text" name="ipaddress" readonly="readonly" value="<%=(String)request.getAttribute("ipaddress") %>"></td>
        </tr>       
        <tr>
            <th scope="row">2</th>
            <td>First Name:**</td>
            <td><input type="text" name="fname" value=""></td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>Last Name:</td>
            <td><input type="text" name="lname" value=""></td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>Designation:</td>
            <td><input type="text" name="designation" value=""></td>
        </tr>
        <tr>
            <th scope="row">5</th>
            <td>Email:</td>
            <td><input type="text" name="email" placeholder="abcd@xyz.com" value=""></td>
        </tr>
        <tr>
            <th scope="row">6</th>
            <td>Mobile:**</td>
            <td><input type="text" name="mobile" placeholder="1234567890" value=""></td>
        </tr>
        <tr>
            <th scope="row">7</th>
            <td>Location:</td>
            <td><input type="text" name="location" value=""></td>
        </tr>
        <tr>
            <th scope="row">8</th>
            <td>MAC Address:**</td>
            <td><input type="text" id="macAddress" name="mac" placeholder="ab:cd:ef:gh:ij:kl" value=""></td>
        </tr>
        <tr>
            <th scope="row">9</th>
            <td>Assing Date:</td>
            <td><input type="date" name="adate" placeholder="MM/DD/YYYY" value=""></td>
        </tr>
        <tr>
            <th scope="row">10</th>
            <td>End Date:</td>
            <td><input type="date" name="edate" placeholder="MM/DD/YYYY" value=""></td>
        </tr>
        <tr>
            <th scope="row">11</th>
            <td>Weather Antivirus Installed:(yes/no)</td><td>
                <INPUT TYPE="radio" NAME="radios" VALUE="radio1" CHECKED>
                Yes
                <BR>
                <INPUT TYPE="radio" NAME="radios" VALUE="radio2">
                No
                <BR>
            </td>
        </tr>

        <tr>
            <th scope="row">12</th>
            <td>Weather Windows Genuine:(yes/no)</td>
            <td>
                <INPUT TYPE="radio" NAME="radioswin" VALUE="radiowin1" CHECKED>
                Yes
                <BR>
                <INPUT TYPE="radio" NAME="radioswin" VALUE="radiowin2">
                No
                <BR>
            </td>
        </tr>
        <tr>
            <th scope="row">13</th>
            <td>OS Version:</td>
            <td><input type="text" name="osversion" placeholder="Linux/Unix/Win" value=""></td>
        </tr>
        <tr>
            <th scope="row"></th>
            <td align="right">
                <button type="submit" class="btn btn-primary" value="submit" >Submit</button>
                <button type="reset" class="btn btn-primary" >Reset</button>
            </td>
        </tr>
    </table>            
</form>
</div>
  

<br><br><br><br><br>

     <script type="text/javascript" src="j-query.js"></script>
     <script type="text/javascript" src="bootstrap.js"></script>
     <script>
            var macAddress = $("#macAddress");

            $(function () {
               $("#dialog-message").dialog({
                   modal: true,
               });
            });

            function formatMAC(e) {
               var r = /([a-f0-9]{2})([a-f0-9]{2})/i,
                   str = e.target.value.replace(/[^a-f0-9]/ig, "");

               while (r.test(str)) {
                   str = str.replace(r, '$1' + ':' + '$2');
               }

               e.target.value = str.slice(0, 17);
            };

            macAddress.on("keyup", formatMAC);
     </script>
</body>
</html>

