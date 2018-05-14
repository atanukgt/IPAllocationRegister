<%@page language="java" import="java.util.*" %>
<html>
<head>
<title>Data Page</title>
</head>
<body> 
<h1 align="center"> IP Allocation Register</h1>
<h2 align="center">Report</h2>
    <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("email")==null)
      response.sendRedirect("loginpage.jsp");

  %>


<a href="logout">
<h4 align="right"> Logout</h4>
</a>
<br>

<table align="center" border="2" cellspacing="3" cellpadding="1">
<tr>
<td align="center"><b>IP Address</b></td>
<td align="center"><b>First Name</b></td>
<td align="center"><b>Last Name</b></td>
<td align="center"><b>Designation</b></td>
<td align="center"><b>E-mail</b></td>
<td align="center"><b>Mobile</b></td>
<td align="center"><b>Location</b></td>
<td align="center"><b>Assing Date</b></td>
<td align="center"><b>End Date</b></td>
<td align="center"><b>MAC Address</b></td>
<td align="center"><b>Antivirus Installed</b></td>
<td align="center"><b>Genuine Windows</b></td>
<td align="center"><b>ID</b></td>
</tr>
<%Iterator itr;%>
<% List data= (List)request.getAttribute("data");
for (itr=data.iterator(); itr.hasNext(); )
{
%>
<tr>
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

<a href="Update.jsp"><p align="center">Update</p></a>
<a href="Deletedetails.jsp"><p align="center">Delete Details</p></a>
<a href="AddDetails.jsp"><p align="center">Add Details</p></a>
<a href="Menupage.jsp"><p align="center">Go Back To Menu</p></a>

</body>
</html>