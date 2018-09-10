$(function() {
    $('#depart').change(function() {
    	var department=$('#depart').val();
    	
        $.ajax({
            type: "POST",
            url: "getexamdetail",
            data: { depart : department},
            dataType: 'json',	
            success : function(data){
            	$("#examsinfo").empty();
            	for (key in data) {
            	    $('#examsinfo').append('<option value="'  + data[key]+ '">' + data[key] + '</option>');
            	  }
            }, 
            error:function(jqXHR, textStatus, errorThrown) {
                alert("HII i am bffack");
            }
        });
    });
});


