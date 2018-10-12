<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin</title>
        <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
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
<img src="${pageContext.request.contextPath}/resources/img/admin.png" alt="Loading" style="width:100%;">
<p id="nam">WELCOME  ${nam}</p> 
<label class="logoutLblPos">
    <button onclick="window.location.href='/onlineportal/admin/logoutfromadmin'"><span>Log Out</span></button>
  </label>
<div class="container">
<button class="button"  onclick="window.location.href='/onlineportal/admin/regist'" ><span>Create Aspirant </span></button>
<button class="button"  onclick="window.location.href='/onlineportal/admin/exam'"><span>Exam </span></button>
<button class="button"  onclick="window.location.href='/onlineportal/admin/upload'"><span>UPload Q/A </span></button>
<button class="button"   onclick="window.location.href='/onlineportal/admin/setting'"><span> Setting</span></button>
</div>
</body>
</html>