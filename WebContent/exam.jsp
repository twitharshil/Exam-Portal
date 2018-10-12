<!DOCTYPE html>
<html>
<head>
       <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/resources/css/exam.css" rel="stylesheet">
       <title>Exam </title>
    </head>
<body>
<img src="${pageContext.request.contextPath}/resources/img/exam.png"  alt="Coming" style="width:100%; opacity: 0.95">
<p id="msg">${msg}</p> 
<label class="logoutLblPos">
     <button class="logoutLblPos" onclick="window.location.href='/onlineportal/admin/logoutfromexam'"><span>Log Out</span></button>
  </label>
  <p id="nam">WELCOME  ${nam}</p> 
   <form action="registerexam" method="post" style="border:1px solid #ccc">
       <div class="container1">
       <h1>Exam Details</h1>
       <hr>
       <label for="Name"><b>Exam Name</b></label>
    	<input type="text" placeholder="Enter Name" name="Examname" required> 
      
      <br>
        <label for="Department"><b>Department :</b></label>
        <select name="Department">
         <option value="none" selected>--Please choose an option--</option>
         <option value="IT">IT</option>
         <option value="Sales">Sales</option>
         <option value="Marketing">Marketing</option>
         <option value="Other">Other</option>
        </select>
        <br><br>    
       <label for="Date"><b>Exam Date:</b></label>
       <input type="date" name="Examdate" >
       <br><br>
     
     <label for="Duration"><b>Duration : (In Minutes)</b></label>
     <input type="number" placeholder="Duration" name="Duration" min=1  required>
     
     <label for="Exam Type"><b>Exam Type</b></label>
          <input type="radio" name="Examtype" value="One"> One By One
          <input type="radio" name="Examtype" value="All"> All At Once <br><br>
     
     <label for="Total Question"><b>Total Question</b></label>
     <input type="number" placeholder="Enter Total question" name="Totalquestion" min=1  required>
          <div class="clearfix">
             <button type="submit" class="okbtn">Ok</button>
             <button class="cancelbtn">Cancel</button>
           </div>
     </div>
   </form>

</body>
</html>