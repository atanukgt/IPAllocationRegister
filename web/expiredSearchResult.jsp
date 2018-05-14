<%-- 
    Document   : expiredSearchResult
    Created on : 26 Mar, 2018, 11:03:26 PM
    Author     : Souvik
--%>

<%@page language="java" import="java.util.*" import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: center;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: black;
    color: white;
}

#myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

</style>
        
        <title>Search Result</title>
    </head>
    
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
    

      <link rel="stylesheet" href="bootstrap.css">
      <script src="j-query.js"></script>
      <script src="bootstrap.js"></script>
    

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
      <a class="navbar-brand" href="#">NIC Tripura</a>
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
            
<div class="container-fluid">
  <h1 align="center">Search Report</h1> 
  <h3 align="center">Search for: <%=(String)request.getAttribute("reportype")%> </h3>
  <h4 align="center"><%=(String)request.getAttribute("checkby2")%> </h4>
  
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for IP address.." title="Type in a name">

<table id="myTable">
    <tr>
    <th align="center"><b>IP Address</b></th>
    <th align="center"><b>First Name</b></th>
    <th align="center"><b>Last Name</b></th>
    <th align="center"><b>Designation</b></th>
    <th align="center"><b>E-mail</b></th>
    <th align="center"><b>Mobile</b></th>
    <th align="center"><b>Location</b></th>
    <th align="center"><b>Assing Date</b></th>
    <th align="center"><b>End Date</b></th>
    <th align="center"><b>MAC Address</b></th>
    <th align="center"><b>Antivirus Installed</b></th>
    <th align="center"><b>Genuine Windows</b></th>
    <th align="center"><b>OS Version</b></th>
    <th align="center"><b>ID</b></th>
    </tr>
    <%Iterator itr;
      String st=null;%>
    <% List data= (List)request.getAttribute("data");
    for (itr=data.iterator(); itr.hasNext(); )
    {
    %>
    <tr id="SomeID">
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    <td align="center"><%=itr.next()%></td>
    </tr>
    <%}%>
</table>

<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>

        </body>
        <br>
        <a href="Menupage.jsp"><p align="center">Back to Home</p></a>
        
        <br><br>
<footer align="center" class="bg-secondary">Copyright &copy; NIC, Kailasahar</footer>

</div>
</html>
