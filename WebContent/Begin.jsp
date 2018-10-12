<!DOCTYPE html>

<html lang="en">
<head>
  <title>Begin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="${pageContext.request.contextPath}/resources/css/begin.css" rel="stylesheet">
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-bootpag/1.0.4/jquery.bootpag.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/begin.js"></script>
   </head>
<body  onload="noBack();" >
<div id="starttime"></div>
<img src="${pageContext.request.contextPath}/resources/img/upload.png"  alt="Coming" style="width:100%;">
<p id="nam">WELCOME  ${nam}</p> 
<div id="showtime"></div>
<hr>
    <div class="container">
     
        <div id="no"></div> 
        <input type="Text" class="Question"  placeholder="Question" name="Question" id="question" readonly="readonly" >
        <input id="checkBox" type="checkbox"  value="marked1" name="checkbox">
        <input type="Text" class="opt A"  name="optiona" id="optiona" readonly="readonly">
        <br>
        <input id="checkBox1" type="checkbox" value="marked2" name="checkbox">
        <input type="Text" class="opt B" placeholder="Option B" name="optionb" id="optionb" readonly="readonly" >
        
        <br>
        <input id="checkBox2" type="checkbox" value="marked3" name="checkbox">
        <input type="Text" class="opt C" placeholder="Option C" name="optionc" id="optionc" readonly="readonly" >
        <br>
         <input id="checkBox3" type="checkbox" value="marked4" name="checkbox">
         <input type="Text" class="opt D" placeholder="Option D" name="optiond" id="optiond" readonly="readonly" >
        <button type="button" class="back">Back</button>
        <button type="button" class="next">Next</button>
        <button type="button" class="submit">Submit </button>
     </div>
</body>
</html>
