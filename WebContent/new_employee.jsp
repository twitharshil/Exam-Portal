<!DOCTYPE html>
<html>
<head>
       <meta name="viewport" content="width=device-width, initial-scale=1">
               <link href="${pageContext.request.contextPath}/resources/css/new_employee.css" rel="stylesheet">

       <title>Create_Aspirant</title>
    </head>
<body>
<img src="${pageContext.request.contextPath}/resources/img/enterpreneur.png" alt="Coming" style="width:100%;">
<p id="msg">${msg}</p> 
<p id="nam">WELCOME  ${nam}</p> 
<label class="logoutLblPos">
      
     <button class="logoutLblPos" onclick="window.location.href='/onlineportal/admin/logoutfromregistration'"><span>Log Out</span></button>
  </label>
<form action="create" method="post"  >
  <div class="container1">
    <h1>Aspirant Details</h1>
    <hr>
    <label for="Name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>
    
    <label for="email"><b> Username</b></label>
    <input type="text" placeholder="Enter Email" name="username" required>
   
     <label for="Department"><b>Department :</b></label>
          <select name="department">
         <option value="IT">IT</option>
         <option value="Sales">Sales</option>
         <option value="Marketing">Marketing</option>
         <option value="Other">Other</option>
          </select>
          <div class="clearfix">
             <button class="signupbtn">Create</button>
           </div>
     </div>
   </form>

</body>
</html>