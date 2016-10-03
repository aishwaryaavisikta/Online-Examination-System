function forgotpass1validate() {
/*VALIDATION FOR PASSWORD*/
	var newpassword = document.getElementById("newpassword").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	var p = newpassword.length;
	var n = confirmpassword.length;
	var u = document.forgotpassword1.newpassword.value;
	var w = document.forgotpassword1.confirmpassword.value;
	if(u=="") {
	alert("PLEASE ENTER YOUR  NEW PASSWORD");
	return false;
	}
	else if(p<4||p>16) {
		alert("NEW PASSWORD SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(w=="") {
	alert("PLEASE ENTER YOUR CONFIRM PASSWORD");
	return false;
	}
	else if(n<4||n>16) {
		alert("CONFIRM PASSWORD SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if (newpassword != confirmpassword){
        alert("PASSWORDS DO NOT MATCH");
		return false;
	}
	else{
	return true;
	}
}