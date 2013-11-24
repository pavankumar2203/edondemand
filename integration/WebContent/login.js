
function testResults(form) { 
	if ((form.userId.value=="")||(form.userId.value.trim()=="")) { 
		alert("User ID can not be empty."); 
	    form.userId.focus();  
	} else if ((form.pwd.value=="")||(form.pwd.value.trim()=="")) { 
		alert("Password can not be empty."); 
	    form.pwd.focus();  
	} else {
 		form.submit();
    }
} 