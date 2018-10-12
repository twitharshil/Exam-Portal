<!DOCTYPE html>
<html>
<head>
       <meta name="viewport" content="width=device-width, initial-scale=1">
               <link href="${pageContext.request.contextPath}/resources/css/Appear.css" rel="stylesheet">
                <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
                <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/appear.js"></script>
                <title>Exam </title>
    </head>
<body>
     <img src="${pageContext.request.contextPath}/resources/img/exam.png"  alt="Coming" style="width:100%; opacity: 0.6">
     <p id="nam">WELCOME  ${nam}</p> 
     <label class="logoutLblPos">
     <button class="logoutLblPos" onclick="window.location.href='/onlineportal/student/logoutfromappear'"><span>Log Out</span></button>
     </label>
     <form method ="post" action="begin" >
     <div class="container1">
     <label for="Name" ><b>Exam Name :</b></label>
         <select id="Exam" name="ex" style="width: 200px;">
         <option value="none" selected >--Please choose an option--</option>
         </select>
         <br><br>
       <h1 >Rules and Regulations :</h1>        
       <ul><li>Aspirants are to follow any instructions given by the invigilators . Failure to follow instruction given by the invigilators may lead to Aspirant being penalised.
        </li>
        <li>Aspirants are advised that good time management is essential.  They should not spend too much time on few questions and leave no time for others.
        </li>
        <li>Aspirants are advised to read the questions carefully. No marks are awarded for Leaving Question Blank.
        </li>
       <li>Aspirants should Bring their own Stationary required.
        </li>
         </ul>
        <button type="submit" id="target" class="Start" >Start</button>   
     </div>
     </form>
</body>
</html>