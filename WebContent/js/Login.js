function loginvalidate() {
	
/*VALIDATION FOR EMAIL*/
	var x = document.login.email.value;  
	var atposition = x.indexOf("@");  
	var dotposition = x.lastIndexOf(".");  
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
		alert("PLEASE ENTER A VALID EMAIL ADDRESS IN THE FORMAT OF very.common@example.com ");  
		return false; 
	}	
	/*VALIDATION FOR PASSWORD*/
	var password = document.getElementById("password").value;
	var p = password.length;
	var u = document.login.password.value;
	if(u=="") {
	alert("PLEASE ENTER YOUR PASSWORD");
	return false;
	}
	else if(p<4||p>16) {
		alert("PASSWORD SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
}