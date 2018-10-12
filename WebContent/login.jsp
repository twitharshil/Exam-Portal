<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html lang="en">
    <head>
        <!-- title -->
        <title>NAME OF ORGANISATION</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1" />
        <meta name="author" content="HARSHIL">
        <meta name="description" content="">
        <meta name="keywords" content="">
        <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/myscripts.js"></script>
       </head>	
    <body>
    
        <img src="${pageContext.request.contextPath}/resources/img/port.png" alt="Norway" style="width:100%;"/>
        <div class="container1" id="hello">
            <form action="/onlineportal/login/loginpro" method="post"  >
              <div class="imgcontainer">
              <img src="${pageContext.request.contextPath}/resources/img/login-image.png" alt="Avatar" class="avatar" />
              </div>
              <div class="container">
                <label for="UserName"><b>UserName</b></label>
                <input type="text" id="username" placeholder="Enter Username" name="username" required>
                <span id="usernameError"></span>
                <br>
                <label for="Password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>
                     
                <button type="submit" >Login</button>
               </div>
            
          
          </form >
        </div>
        
    </body>     
       
</html>