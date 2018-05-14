
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>SDC login</title>
  <script src="https://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script>


  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css/style.css">
      <link rel="stylesheet" href="style.css" type="text/css"/>


  
</head>

<body>
    
    <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  %>
    
  <div class="login" >
  <header class="header">
    <span class="text">LOGIN</span>
    <span class="loader"></span>
  </header>
  <form class="form" method="post" action="Login">  
    <input class="input" type="text" name="email">
    <input class="input" type="password" name="pass">
    <button class="btn" type="submit"></button>
  </form>
</div>
  <form action="register.jsp" method="POST">
<button class ="resetbtn" type= "Submit">Register User
</button>
  </form>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>

</body>
</html>