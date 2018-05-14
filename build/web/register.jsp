<%-- 
    Document   : register
    Created on : Jul 10, 2017, 12:09:03 AM
    Author     : Sagar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <link rel="stylesheet" type="text/css" href="bootstrap.css">

<div class="jumbotron">
  <div class="container">
    <h1 class="display-4">Register new Account</h1>
  </div>
</div>

        <br><br>
    <div class="container">
        <form action="AddUser" method="POST">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="text" name="UserName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Create Username">
            <small id="emailHelp" class="form-text text-muted">Create Your Unique Username Here.</small>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Create Password">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Master Password</label>
            <input type="password" name="masterpassword" class="form-control" id="exampleInputPassword1" placeholder="Enter Master Password">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
        
     <script type="text/javascript" src="j-query.js"></script>
     <script type="text/javascript" src="bootstrap.js"></script>
    </body>
</html>
