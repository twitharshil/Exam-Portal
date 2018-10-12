<!DOCTYPE html>
<html>
<head>
        
       <meta name="viewport" content="width=device-width, initial-scale=1">
         <title>Settings</title>
               <link href="${pageContext.request.contextPath}/resources/css/setting.css" rel="stylesheet">
                <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
               <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Setting.js"></script>
         </head>
<body>
<img src="${pageContext.request.contextPath}/resources/img/setting.png"  alt="Coming" style="width:100%; opacity: 0.8">
<p id="msg">${msg}</p> 
<p id="nam">WELCOME  ${nam}</p> 
<label class="logoutLblPos">
     <button class="logoutLblPos" onclick="window.location.href='/onlineportal/admin/logoutfromsetting'"><span>Log Out</span></button>
  </label>
<form action="updatepassword" method="post" >
 
  <div class="container1">
    <h1>Settings</h1>
    <hr>
    
    <label for="Current Password"><b>Current Password</b></label>
    <input type="Password" placeholder="Current Password" id="CurrentPassword" name="CurrentPassword" required>
    <br>
    <label for="New Password"><b>New Password  </b></label>
    <input type="Password" placeholder="New Password"  id="NewPassword" name="NewPassword" onkeyup='check();' required>
    <br>
     <label for="Confirm Password"><b>Confirm Password</b> <span id="message"></span>
    <input type="Password" placeholder="Confirm Password" id="ConfirmPassword" name="ConfirmPassword" onkeyup='check();' required>
    </label>
          <div class="clearfix">
             <button type="submit" class="okbtn">Ok</button>
             
           </div>
     </div>
   </form>

</body>
</html>