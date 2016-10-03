function addsubvalidate() {
	
	/*VALIDATION FOR BRANCH NAME*/
	var branchname = document.getElementById("branchname").value;
	var b = branchname.length;
	var b1 = document.addsub.branchname.value;
	if(b1=="") {
		alert("PLEASE ENTER YOUR  BRANCH NAME");
		return false;} 
		/*VALIDATION FOR SUBJECT CODE*/
	var subjectcode = document.getElementById("subjectcode").value;
	var c = subjectcode.length;
	var c1 = document.addsub.subjectcode.value;
	if(c1=="") {
		alert("PLEASE ENTER YOUR  SUBJECT CODE");
		return false;} 
		/*VALIDATION FOR SUBJECT NAME*/
	var subjectname = document.getElementById("subjectname").value;
	var s = subjectname.length;
	var s1 = document.addsub.subjectname.value;
	if(s1=="") {
		alert("PLEASE ENTER YOUR  SUBJECT NAME");
		return false;} 
	else{
		return true;
	}
}