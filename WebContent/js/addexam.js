function examvalidate() {
	
	/*VALIDATION FOR TOTAL MARK*/
	var totalmark = document.getElementById("totalmark").value;
	var f = totalmark.length;
	var f1 = document.addexam.totalmark.value;
	if(f1=="") {
		alert("PLEASE ENTER TOTAL  NAME");
		return false;} 
	
	/*VALIDATION FOR TIME*/
	var time = document.getElementById("time").value;
	var l = time.length;
	var l1 = document.addexam.time.value;
	if(l1=="") {
		alert("PLEASE ENTER TIME");
		return false;} 

	/*VALIDATION FOR TOTAL QUESTION*/
	var totalquestion = document.getElementById("totalquestion").value;
	var m = totalquestion.length;
	var m1 = document.addexam.totalquestion.value;
	if(m1=="") {
		alert("PLEASE ENTER THE NUMBER OF TOTAL QUESTION");
		return false;} 
	/*VALIDATION FOR DATE*/
	var date = document.getElementById("date").value;
	var n = date.length;
	var n1 = document.addexam.date.value;
	if(n1=="") {
		alert("PLEASE ENTER DATE");
		return false;} 
	else{
       return true;
	}
}
	