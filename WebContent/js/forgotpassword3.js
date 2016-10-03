function forgotpass2validate(){
	var x = document.forgetpassword.email.value;  
	var atposition = x.indexOf("@");  
	var dotposition = x.lastIndexOf(".");  
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
		alert("PLEASE ENTER A VALID EMAIL ADDRESS IN THE FORMAT OF very.common@example.com ");  
		return false; 
	}	
/*VALIDATION FOR SECURITY_ANSWER*/
	var security_answer = document.getElementById("security_answer").value;
	var f = security_answer.length;
	var f1 = document.forgetpassword.security_answer.value;
	if(f1=="") {
		alert("PLEASE ENTER YOUR  NICK NAME");
		return false;} 
	else if(f>=10) {
		alert("NICK NAME SHOULD NOT BE MORE THAN 10 CHARACTERS");
		return false;
	}	
	else {
		return true;
	}
}