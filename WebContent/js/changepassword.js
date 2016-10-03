function changepassvalidate()
{
	var password = document.getElementById("password").value;
	var newpassword = document.getElementById("newpassword").value;
	var retypepassword = document.getElementById("retypepassword").value;
	var p = password.length;
	var m = newpassword.length;
	var n = retypepassword.length;               
	var u = document.changepassword.password.value;
	var v = document.changepassword.newpassword.value;
	var w = document.changepassword.retypepassword.value;
	if(u=="") {
	alert("PLEASE ENTER YOUR PASSWORD");
	return false;
	}
	else if(p<4||p>16) {
		alert("PASSWORD SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(v=="") {
	alert("PLEASE ENTER YOUR NEW PASSWORD");
	return false;
	}
	else if(m<4||m>16) {
		alert("NEW PASSWORD SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(w=="") {
	alert("PLEASE ENTER YOUR RE-TYPE PASSWORD");
	return false;
	}
	else if(n<4||n>16) {
		alert("RE-TYPE PASSWORD SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if (newpassword != retypepassword){
        alert("PASSWORDS DO NOT MATCH");
		return false;
	}
	else{
	return true;
	}

	

}