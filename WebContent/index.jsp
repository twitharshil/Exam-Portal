<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin</title>
        <link href="${pageContext.request.contextPath}/resources/css/admin.css" rel="stylesheet">
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/img/admin.png" alt="Loading" style="width:100%;">
<label class="logoutLblPos">
     <button><span>Log Out</span></button>
  </label>
<div class="container">
<button class="button"  onclick="window.location.href='/onlineportal/login/'" ><span>Login </span></button>
<button class="button"  onclick="window.location.href='/onlineportal/admin/'"><span>Admin </span></button>
<button class="button"  onclick="window.location.href='/onlineportal/student/'"><span>Student </span></button>

</div>
</body>
</html>