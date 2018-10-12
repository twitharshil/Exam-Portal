<!doctype html>
<html lang="en">
    <head>
       <meta name="viewport" content="width=device-width, initial-scale=1">
               <link href="${pageContext.request.contextPath}/resources/css/employee.css" rel="stylesheet">

       <title>Aspirant</title>
    </head>
    <body>
        
      <img src="${pageContext.request.contextPath}/resources/img/employee.png" alt="Loading" style="width:100%;">
      <p id="nam">WELCOME  ${nam}</p> 
      <label class="logoutLblPos">
     <button onclick="window.location.href='/onlineportal/admin/logoutfromregist'"><span>Log Out</span></button>
  </label>
        <div class="container">
       <button class="btn info"  onclick="window.location.href='/onlineportal/admin/employee'"><span>Create Aspirant </span></button>
       <button class="btn info"  onclick="window.location.href='/onlineportal/admin/update'"><span>Update Aspirant</span></button>
        </div>
    </body>
    
</html>