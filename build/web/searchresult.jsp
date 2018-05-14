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

td {
    text-align: center;
    padding: 8px;
}

th{
    text-align: center;
    padding: 8px;    
}

tr:nth-child(even){background-color: #f2f2f2}

#myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 40%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
  margin-left: 40px;
}

#myInput1 {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 40%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
  margin-left: 180px;
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
<script src="bootstrap.js"></script>
<script src="j-query.js"></script>
<script src="jspdf.js"></script>
<script src="autotable.js"></script>

<body>
    
<div class="container-fluid">

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
            

  <h1 align="center">Search Report</h1> 
  <h3 align="center">Search for: <%=(String)request.getAttribute("reportype")%> </h3>
  <h4 align="center"><%=(String)request.getAttribute("checkby2")%> </h4>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for IP address.." title="Type in a name">
<input type="text" id="myInput1" onkeyup="myFunction1()" placeholder="Search for name.." title="Type in a name">

<div>
<table id="myTable">
    <tr>

    <th><b>IP Address</b></th>
    <th><b>First Name</b></th>
    <th><b>Last Name</b></th>
    <th><b>Designation</b></th>
    <th><b>E-mail Address</b></th>
    <th><b>Mobile</b></th>
    <th><b>Location</b></th>
    <th><b>Assing Date</b></th>
    <th><b>End Date</b></th>
    <th><b>MAC</b></th>
    <th><b>Antivirus</b></th>
    <th><b>Genuine OS</b></th>
    <th><b>OS Version</b></th>
    <th><b>ID</b></th>

    </tr>
    <%Iterator itr;%>
    <% List data= (List)request.getAttribute("data");
    for (itr=data.iterator(); itr.hasNext(); )
    {
    %>

    <tr class="id123">

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
    <td class="idnoget text-warning" align="center"><%=itr.next()%></td>

    </tr>

    <%}%>

    <form action="updateit" name="formname" method="post">
        <input type="hidden" name="id"/>
    </form>

</table>
</div>

        <br>
        
         <a href="javascript:demoFromHTML()"><p align="center">Print</p></a>
        
        <a href="Menupage.jsp"><p align="center">Back to Home</p></a>
        
        <br><br>
<footer align="center" class="bg-secondary">Copyright &copy; NIC, Kailasahar</footer>

</div>

<script src="findElement.js"></script>
<script src="printrepopdf.js"></script>

</body>

</html>
