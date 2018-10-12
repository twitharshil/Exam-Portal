<!DOCTYPE html>
<html lang="en">
<head>
  <title>Upload Q/A</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="${pageContext.request.contextPath}/resources/css/upload.css" rel="stylesheet">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/upload.js"></script>
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/img/upload.png"  alt="Coming" style="width:100%; opacity: 0.98">
<p id="msg">${msg}</p> 
<p id="nam">WELCOME  ${nam}</p> 
<label class="logoutLblPos">
     <button class="logoutLblPos" onclick="window.location.href='/onlineportal/admin/logoutfromupload'"><span>Log Out</span></button>
  </label>
  
  <form class="options" action="Uploadqa" method="post">
         <div class="container">
         <label for="Department"><b>DEPARTMENT :</b></label>
         <select id="depart" name="depart" required>
         <option value="none" >--Please choose an option--</option>
         <option value="Sales">Sales</option>
         <option value="IT">IT</option>
         <option value="Marketing">Marketing</option>
         <option value="Other">Other</option>
         </select>
         <br>
        <label for="Exam"><b>EXAM :</b></label>
        <select name="Exam" id="examsinfo" required >
        <option value="none" >--Please choose an option--</option>
        </select>
        <br>
         <hr>
       <label for="Question"><b>QUESTION :- </b></label>
       <input type="Text" class="Question"  placeholder="Question" name="Question" required>
       
       <p> ( <input id="checkBox" type="checkbox" value= "CHecked" checked> Mark For Correct Answer )</p>        
       <label for="option"><b>A</b></label>
        <input type="Text" class="opt A" name="optionA" required>
        <input id="checkBox" type="checkbox" value="answera" name="AnswerA">
       
        <label for="option"><b>B</b></label>
        <input type="Text" class="opt B" name="optionB" required>
        <input id="checkBox" type="checkbox" value="answerb" name="AnswerB">
        <br>
        <label for="option"><b>C</b></label>
        <input type="Text" class="opt C" name="optionC" required>
        <input id="checkBox" type="checkbox" value="answerc" name="AnswerC">
        
        <label for="option"><b>D</b></label>
        <input type="Text" class="opt D" name="optionD"  required>
         <input id="checkBox" type="checkbox" value="answerd" name="AnswerD">
         <button type="submit">Submit</button>
        </div>
    </form>


</body>
</html>
