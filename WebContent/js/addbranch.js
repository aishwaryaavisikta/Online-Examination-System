function addbranchvalidate() {
	
	/*VALIDATION FOR BRANCH NAME*/
	var branchname = document.getElementById("branchname").value;
	var b = branchname.length;
	var b1 = document.addbranch.branchname.value;
	if(b1=="") {
		alert("PLEASE ENTER BRANCH  NAME");
		return false;} 
	else {
		return true;
	}
}