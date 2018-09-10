var obj = new Array();
var  ans = new Array();
var index;
var x;

window.history.forward();
function noBack() 
{ window.history.forward(); }

$(document).ready(function(){
	$.ajax({
	    type: "GET",
	    url: "examdedo",
	    dataType: 'json',	
        success : function(ghj){
     
         index=ghj.length-1;
         obj[ghj.length-1]=ghj[ghj.length-1];
         
         var y =index+1;
      	 document.getElementById("no").innerHTML = "Question :"+y+"";
	 	document.getElementById("question").value = obj[index]["question"];
	 	document.getElementById("optiona").value = obj[index]["optionA"];
	 	document.getElementById("optionb").value = obj[index]["optionB"];
	 	document.getElementById("optionc").value = obj[index]["optionC"];
	 	document.getElementById("optiond").value = obj[index]["optionD"];
	 	index--; 
	    for(i=ghj.length-2;i>=0;i--){
        	    
        	 obj[i]=ghj[i];
        	 copy = document.querySelector('.container').cloneNode(true);
        	 document.querySelector('.container').parentNode.insertBefore(copy, document.querySelector('.container'));      
        	     $('#question').empty();
        	     $('#optiona').empty();
        	     $('#optionb').empty();
        	     $('#optionc').empty();
        	    $('#optiond').empty();
        	    
        	    var y =index+1;
             	document.getElementById("no").innerHTML = "Question :"+y+"";
        	document.getElementById("question").value = obj[index]["question"];
        	document.getElementById("optiona").value = obj[index]["optionA"];
        	document.getElementById("optionb").value = obj[index]["optionB"];
        	document.getElementById("optionc").value = obj[index]["optionC"];
        	document.getElementById("optiond").value = obj[index]["optionD"];
        	index--; 
        }
       },
        error:function(jqXHR, textStatus, errorThrown) {
            alert("HII i m here in beginall.js ready function");
        }
      });
 });

$(document).ready(function(){

    $(".submit").click(function(){
    
    	var checkbox1 = document.querySelectorAll("[id='checkBox']");
    	var checkbox2 = document.querySelectorAll("[id='checkBox1']");
    	var checkbox3 = document.querySelectorAll("[id='checkBox2']");
    	var checkbox4 = document.querySelectorAll("[id='checkBox3']");
    	alert(checkbox1)
    	
    	for(i=0;i<obj.length;i++){
    	    
    		var array= new Array();
    		var box=false;
    		var box1=false;
    		var box2=false;
    		var box3=false;
    		if(checkbox1[i].checked){
    			box=true;
    		}
    		if(checkbox2[i].checked){
    			box1=true;
    		}
    		if(checkbox3[i].checked){
    			box2=true;
    		}
    		if(checkbox4[i].checked){
    			box3=true;
    		}
    		array = {"questionId" :obj[i]["questionId"],"optionA" : box,"optionB" : box1,"optionC" : box2 ,"optionD" : box3};
    		ans[i]=array;
    		alert(JSON.stringify(ans));
    	}
    	
       $.ajax({
    	    
    	    type: "POST",
    	    url: "responsed",
    	    data : JSON.stringify(ans),
    	    contentType: "application/json", 
    	    success : function(ghj){
    	    	 window.location.href ="thankyou?score="+ ghj;
    	    },
            error:function(jqXHR, textStatus, errorThrown) {
                alert("HII n==="+errorThrown);
            }
         });
     });
});


function f2() {
	
	if (parseInt(sec) > 0) {
     sec = parseInt(sec) - 1;
     document.getElementById("showtime").innerHTML = "Your Left Time  is : M:"+min+" , S:" + sec+" ";
     tim = setTimeout("f2()", 1000);
    }
  else {
     if (parseInt(sec) == 0) {
         min = parseInt(min) - 1;
         if (parseInt(min) == 0) {
             clearTimeout(tim);
             jQuery(function(){
             	   jQuery('.submit').click();
             	});
         }
         else {
             sec = 60;
             document.getElementById("showtime").innerHTML = "Your Left Time  is : M:" + min + " S:" + sec + "";
             tim = setTimeout("f2()", 1000);
             }
         }
      }
 }   

var tim;
var min;
var sec;
$(document).ready(function(){
	
	$.ajax({
	    type: "GET",
	    url: "timer",
	    dataType: 'json',	
        success : function(data){
        	    
        	    min = data-1 ;
		        sec = 60;
		        var f = new Date();
		       document.getElementById("starttime").innerHTML = "Exam Started At : H:"+f.getHours() +" M:"+f.getMinutes()+" S:"+f.getSeconds()+"" ;
			   f2();
			 },
            error:function(jqXHR, textStatus, errorThrown) {
                 alert("HII i m here in begin js time=="+errorThrown);
             }
        });
});
//
//history.pushState(null, null, window.location.href);
//window.addEventListener('popstate', function (event) {
//    history.pushState(null, null, window.location.href);
//    event.preventDefault();
//    });
//
//
//function disableF5(e) { if ((e.which || e.keyCode) == 116) e.preventDefault(); };
////To disable f5
///* OR jQuery >= 1.7 */
//$(document).on("keydown", disableF5);
//$(document).ready(function () {
//    $(document).on("keydown", function(e) {
//        e = e || window.event;
//        if (e.ctrlKey) {
//            var c = e.which || e.keyCode;
//            if (c == 82) {
//                e.preventDefault();
//                e.stopPropagation();
//            }
//        }
//    });
//});
//$(document).keypress(
//	    function(event){
//	     if (event.which == '13') {
//	        event.preventDefault();
//	      }
//});
//function openPlayerFromTranscript(e, t, r) {
//    var n = "width=1354,height=836,status=0,titlebar=0,scrollbars=0,menubar=0,toolbar=0,location=0,resizable=1";
//    window.open(getPlayerUrlForTranscript(e, t, r), "psplayer", n)
//}




