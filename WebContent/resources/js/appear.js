$(document).ready(function(){
$.ajax({
	    type: "GET",
	    url: "database",
	    dataType: 'json',	
        success : function(data){
        	$("#Exam").empty();
        	for (key in data) {
        	    $('#Exam').append('<option value="'  + data[key]+ '">' + data[key] + '</option>');
        	  }
        }, 
        error:function(jqXHR, textStatus, errorThrown) {
            alert("HII boy febg fb ");
        }
     });
 });
