function profilevalidate() {
	
	/*VALIDATION FOR NAME*/
	var name = document.getElementById("name").value;
	var f = name.length;
	var f1 = document.profile.name.value;
	if(f1=="") {
		alert("PLEASE ENTER YOUR  NAME");
		return false;} 
	else if(f>=25) {
		alert("FIRST NAME SHOULD NOT BE MORE THAN 25 CHARACTERS");
		return false;
	}
	
	/*VALIDATION FOR EMAIL*/
	var x = document.profile.email.value;  
	var atposition = x.indexOf("@");  
	var dotposition = x.lastIndexOf(".");  
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
		alert("PLEASE ENTER A VALID EMAIL ADDRESS IN THE FORMAT OF very.common@example.com ");  
		return false; 
	}		  
	
	/*VALIDATION FOR PHONE NUMBER*/
	var phonenumber = document.getElementById("phonenumber").value;
	var pn1 = phonenumber.length;
	var pn2 = document.profile.phonenumber.value;
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