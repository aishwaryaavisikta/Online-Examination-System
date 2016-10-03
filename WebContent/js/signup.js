function signupvalidate() {
	
	/*VALIDATION FOR FIRST NAME*/
	var fname = document.getElementById("firstname").value;
	var f = fname.length;
	var f1 = document.registration.firstname.value;
	if(f1=="") {
		alert("PLEASE ENTER YOUR FIRST NAME");
		return false;} 
	else if(f>=25) {
		alert("FIRST NAME SHOULD NOT BE MORE THAN 25 CHARACTERS");
		return false;
	}
	
	/*VALIDATION FOR LAST NAME*/
	var lname = document.getElementById("lastname").value;
	var l = lname.length;
	var l1 = document.registration.lastname.value;
	if(l1=="") {
		alert("PLEASE ENTER YOUR LAST NAME");
		return false;} 
	else if(l>=25) {
		alert("LAST NAME SHOULD NOT BE MORE THAN 25 CHARACTERS");
		return false;
	}
	
	/*VALIDATION FOR PASSWORD*/
	var password = document.getElementById("password").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	var p = password.length;
	var n = confirmpassword.length;
	var u = document.registration.password.value;
	var w = document.registration.confirmpassword.value;
	if(u=="") {
	alert("PLEASE ENTER YOUR PASSWORD");
	return false;
	}
	else if(p<4||p>16) {
		alert("PASSWORD SHOULD BE OF 4-16 CHARACTERS");
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
	else if (password != confirmpassword){
        alert("PASSWORDS DO NOT MATCH");
		return false;
	}

	/*VALIDATION FOR EMAIL*/
	var x = document.registration.email.value;  
	var atposition = x.indexOf("@");  
	var dotposition = x.lastIndexOf(".");  
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
		alert("PLEASE ENTER A VALID EMAIL ADDRESS IN THE FORMAT OF very.common@example.com ");  
		return false; 
	}		 
	/*VALIDATION FOR PHONE NUMBER*/
	var phonenumber = document.getElementById("phonenumber").value;
	var pn1 = phonenumber.length;
	var pn2 = document.registration.phonenumber.value;
	if(pn2=="")
	{
		alert("PLEASE ENTER YOUR PHONE NUMBER");
		return false;
	}
	else if(pn1!=10)
	{
		alert("PLEASE ENTER A VALID PHONE NUMBER");
		return false;
	}
	
}