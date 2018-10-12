<!DOCTYPE html>
<html>
<head>
       <meta name="viewport" content="width=device-width, initial-scale=1">
               <link href="${pageContext.request.contextPath}/resources/css/update.css" rel="stylesheet">

       <title>Update</title>
    </head>
<body>
<p id="msg">${msg}</p> 
<img src="${pageContext.request.contextPath}/resources/img/enterpreneur.png" alt="Coming" style="width:100%;">
<p id="nam">WELCOME  ${nam}</p> 
<label class="logoutLblPos">
     <button class="logoutLblPos" onclick="window.location.href='/onlineportal/admin/logoutfromregistration'"><span>Log Out</span></button>
  </label>
<form action="submitupdate" method="post" style="border:1px solid #ccc">
  <div class="container1">
    <h1>Update Details</h1>
    <hr>
    <label for="Name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>
    
    <label for="email"><b>Username</b></label>
    <input type="text" placeholder="Enter Email" name="username" required>
   
     <label for="Department"><b>Department :</b></label>
            <select name="department">
         <option value="IT">IT</option>
         <option value="Sales">Sales</option>
         <option value="Marketing">Marketing</option>
         <option value="Other">Other</option>
          </select>
          <div class="clearfix">
             <button class="signupbtn">Update</button>
             
           </div>
     </div>
   </form>

</body>
</html>