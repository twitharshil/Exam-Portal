<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Thank You</title>
        <link href="${pageContext.request.contextPath}/resources/css/thank.css" rel="stylesheet">
        <script type="text/javascript">
                /*To retain on the same view on Back Click*/
                history.pushState(null, null, window.location.href);
                window.addEventListener('popstate', function (event) {
                    history.pushState(null, null, window.location.href);
                    event.preventDefault();
                    });
        </script>
</head>
<body>
<p id="marks">YOUR SCORE IS :-  ${marks}</p> 
<img src="${pageContext.request.contextPath}/resources/img/thank.png" alt="Norway" style="width:50%" hspace="300"  >
<p id="nam">WELCOME  ${nam}</p> 
<label class="logoutLblPos">
     <button onclick="window.location.href='/onlineportal/student/logoutfromthank'"><span>Log Out</span></button>
  </label>
<div class="container">

</div>
</body>
</html>