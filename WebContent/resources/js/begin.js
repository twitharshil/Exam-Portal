var obj = new Array();
var  ans = new Array();
var index;
var x;

window.history.forward();
function noBack() { window.history.forward(); }

$(document).ready(function(){
	
	$.ajax({
	    type: "GET",
	    url: "examdedo",
	    dataType: 'json',	
        success : function(ghj){
        	
            index=0;
        	$('#question').empty();
        	$('#optiona').empty();
        	$('#optionb').empty();
        	$('#optionc').empty();
        	$('#optiond').empty();
        	
        	for(i=0;i<ghj.length;i++){
        		obj[i]=ghj[i];
        	}
        	var y =index+1;
         	document.getElementById("no").innerHTML = "Question :"+y+"";
        	x =obj[index]["questionId"];
        	document.getElementById("question").value = obj[index]["question"];
        	document.getElementById("optiona").value = obj[index]["optionA"];
        	document.getElementById("optionb").value = obj[index]["optionB"];
        	document.getElementById("optionc").value = obj[index]["optionC"];
        	document.getElementById("optiond").value = obj[index]["optionD"];
        }, 
        error:function(jqXHR, textStatus, errorThrown) {
            alert("HII i m here in begin.js ready function");
        }
        
        
     });
 });

$(document).ready(function(){

    $(".back").click(function(){
    	if(index==0){
    		
    		var array= new Array();
           	var boxes=document.getElementById("checkBox").checked;
        	var boxes1=document.getElementById("checkBox1").checked;
        	var boxes2=document.getElementById("checkBox2").checked;
        	var boxes3=document.getElementById("checkBox3").checked;
     
        	array = {"questionId" :x,"optionA" : boxes,"optionB" : boxes1,"optionC" : boxes2 ,"optionD" : boxes3};
        	ans[index]= array;
        	
    		index=0;
    		
    		var y =index+1;
    		document.getElementById("no").innerHTML = "Question :"+y+"";
    		x =obj[index]["questionId"];
    		
        	document.getElementById("question").value = obj[index]["question"];
        	document.getElementById("optiona").value = obj[index]["optionA"];
        	document.getElementById("optionb").value = obj[index]["optionB"];
        	document.getElementById("optionc").value = obj[index]["optionC"];
        	document.getElementById("optiond").value = obj[index]["optionD"];
        	
        	document.getElementById("checkBox").checked=ans[index]["optionA"];
        	document.getElementById("checkBox1").checked=ans[index]["optionB"];
        	document.getElementById("checkBox2").checked=ans[index]["optionC"];
        	document.getElementById("checkBox3").checked=ans[index]["optionD"];
        	
        }
        else
         {
        	
        	var array= new Array();
           	var boxes=document.getElementById("checkBox").checked;
        	var boxes1=document.getElementById("checkBox1").checked;
        	var boxes2=document.getElementById("checkBox2").checked;
        	var boxes3=document.getElementById("checkBox3").checked;
        	
        	array = {"questionId" :x,"optionA" : boxes,"optionB" : boxes1,"optionC" : boxes2 ,"optionD" : boxes3};
        	ans[index]= array;
        	index--;
        	
        	var y =index+1;
        	document.getElementById("no").innerHTML = "Question :"+y+"";
        	
        	$('#question').empty();
        	$('#optiona').empty();
        	$('#optionb').empty();
        	$('#optionc').empty();
        	$('#optiond').empty();
       
        	 x =obj[index]["questionId"];
        	document.getElementById("question").value = obj[index]["question"];
        	document.getElementById("optiona").value = obj[index]["optionA"];
        	document.getElementById("optionb").value = obj[index]["optionB"];
        	document.getElementById("optionc").value = obj[index]["optionC"];
        	document.getElementById("optiond").value = obj[index]["optionD"];
        	
        	document.getElementById("checkBox").checked=ans[index]["optionA"];
        	document.getElementById("checkBox1").checked=ans[index]["optionB"];
        	document.getElementById("checkBox2").checked=ans[index]["optionC"];
        	document.getElementById("checkBox3").checked=ans[index]["optionD"];
        	}
        
    });
    
    $(".next").click(function(){
    	 if(index==obj.length-1){
    		
    		var array= new Array();
            var boxes=document.getElementById("checkBox").checked;
         	var boxes1=document.getElementById("checkBox1").checked;
         	var boxes2=document.getElementById("checkBox2").checked;
         	var boxes3=document.getElementById("checkBox3").checked;
         	
        	array = {"questionId" :x,"optionA" : boxes,"optionB" : boxes1,"optionC" : boxes2 ,"optionD" : boxes3};
         	ans[index]= array;
    		uncheck();
         	index=obj.length-1;
         	
         	var y =index+1;
         	document.getElementById("no").innerHTML = "Question :"+y+"";
         	
    		x =obj[index]["questionId"];
         	document.getElementById("question").value = obj[index]["question"];
         	document.getElementById("optiona").value = obj[index]["optionA"];
         	document.getElementById("optionb").value = obj[index]["optionB"];
         	document.getElementById("optionc").value = obj[index]["optionC"];
         	document.getElementById("optiond").value = obj[index]["optionD"];
         	
         	
         }
         else
         	{
        	
        	var array= new Array();
           	var boxes=document.getElementById("checkBox").checked;
        	var boxes1=document.getElementById("checkBox1").checked;
        	var boxes2=document.getElementById("checkBox2").checked;
        	var boxes3=document.getElementById("checkBox3").checked;
        	
        	array = {"questionId" :x,"optionA" :boxes,"optionB" : boxes1,"optionC" : boxes2 ,"optionD" : boxes3};
        	ans[index]= array;
        	
        	uncheck();
        	index++;
        	
        	var y=index+1;
        	document.getElementById("no").innerHTML = "Question :"+y+"";
        	
         	$('#question').empty();
         	$('#optiona').empty();
         	$('#optionb').empty();
         	$('#optionc').empty();
         	$('#optiond').empty();
         	
         	x =obj[index]["questionId"];
         	document.getElementById("question").value = obj[index]["question"];
         	document.getElementById("optiona").value = obj[index]["optionA"];
         	document.getElementById("optionb").value = obj[index]["optionB"];
         	document.getElementById("optionc").value = obj[index]["optionC"];
         	document.getElementById("optiond").value = obj[index]["optionD"];
        
         	}
    });
   
    $(".submit").click(function(){
    	 alert("Press OK to Get Score");
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

//history.pushState(null, null, window.location.href);
//window.addEventListener('popstate', function (event) {
//    history.pushState(null, null, window.location.href);
//    event.preventDefault();
//    });

function uncheck()
{
 var uncheck=document.getElementsByTagName('input');
 for(var i=0;i<uncheck.length;i++)
 {
  if(uncheck[i].type=='checkbox')
  {
   uncheck[i].checked=false;
  }
 }
}


function disableF5(e) { if ((e.which || e.keyCode) == 116) e.preventDefault(); };
//To disable f5
/* OR jQuery >= 1.7 */
$(document).on("keydown", disableF5);
$(document).ready(function () {
    $(document).on("keydown", function(e) {
        e = e || window.event;
        if (e.ctrlKey) {
            var c = e.which || e.keyCode;
            if (c == 82) {
                e.preventDefault();
                e.stopPropagation();
            }
        }
    });
});
$(document).keypress(
	    function(event){
	     if (event.which == '13') {
	        event.preventDefault();
	      }
});
function openPlayerFromTranscript(e, t, r) {
    var n = "width=1354,height=836,status=0,titlebar=0,scrollbars=0,menubar=0,toolbar=0,location=0,resizable=1";
    window.open(getPlayerUrlForTranscript(e, t, r), "psplayer", n)
}










