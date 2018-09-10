$(document).ready(function(){
	window.alert("HII");
});

$(document).ready(function(){
    $("#username").change(function(){
    	var email=document.getElementById('username').value;
    	var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    	var is_email=re.test(email);
    	if(!is_email){
    		document.getElementById('usernameError').innerHTML="Enter a valid email address";
    	} 
    });
}); 
