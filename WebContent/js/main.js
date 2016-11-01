function signIn(){
	
	var success = function(){
		window.location.replace("main.jsp");
	}
	
	var error = function(){
		alert('error');
	}
	
	var data = {
			email : document.getElementById('email').value,
			password : document.getElementById('password').value
	}
	
	$.ajax({
	       url : 'login',
	       type : 'POST',
	       data : data,
	       success : success,
	       error: error
	    });
}

function signUp(){
	var success = function(){
		window.location.replace("main.jsp");
	}
	
	var error = function(){
		alert('error');
	}
	
	var data = {
			lastname : document.getElementById('lastname').value,
			firstname : document.getElementById('firstname').value,
			email : document.getElementById('email').value,
			tel : document.getElementById('tel').value,
			password : document.getElementById('password').value		
	}
	
	$.ajax({
	       url : 'signUp',
	       type : 'POST',
	       data : data,
	       success : success,
	       error: error
	    });
}