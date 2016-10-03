function option(){
	
	var question = document.getElementById("question").value;
	var option1 = document.getElementById("option1").value;
	var option2 = document.getElementById("option2").value;
	var option3 = document.getElementById("option3").value;
	var option4 = document.getElementById("option4").value;
	var answer = document.getElementById("answer").value;
	var q = question.length;
	var p = option1.length;
	var m = option2.length;
	var n = option3.length;
	var s = option4.length;
	var t = answer.length;
	var z = document.insertqsn.question.value;
	var u = document.insertqsn.option1.value;
	var v = document.insertqsn.option2.value;
	var w = document.insertqsn.option3.value;
	var x = document.insertqsn.option4.value;
	var y = document.insertqsn.answer.value;
	if(z=="") {
		alert("PLEASE ENTER YOUR QUESTION");
		return false;
	}
	else if(q<4||q>16) {
		alert("QUESTION SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(u=="") {
	alert("PLEASE ENTER YOUR  FIRST OPTION");
	return false;
	}
	else if(p<4||p>16) {
		alert("FIRST OPTION SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(v=="") {
	alert("PLEASE ENTER YOUR SECOND OPTION");
	return false;
	}
	else if(m<4||m>16) {
		alert("SECOND OPTION SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(w=="") {
	alert("PLEASE ENTER YOUR THIRD OPTION");
	return false;
	}
	else if(n<4||n>16) {
		alert("THIRD OPTION SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(x=="") {
	alert("PLEASE ENTER YOUR FOURTH OPTION");
	return false;
	}
	else if(s<4||s>16) {
		alert("FOURTH OPTION SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if(y=="") {
	alert("PLEASE ENTER YOUR CORRECT ANSWER");
	return false;
	}
	else if(t<4||t>16) {
		alert("CORRECT ANSWER SHOULD BE OF 4-16 CHARACTERS");
		return false;
	}
	else if (option1 == answer){
        alert("OPTION DO NOT MATCH WITH CORRECT ANSWER");
		return true;
	}
	else if (option2 == answer){
        alert("OPTION DO NOT MATCH WITH CORRECT ANSWER");
		return true;
	}
	else if (option3 == answer){
        alert("OPTION DO NOT MATCH WITH CORRECT ANSWER");
		return true;
	}
	else if (option4 == answer){
        alert("OPTION DO NOT MATCH WITH CORRECT ANSWER");
		return true;
	}
	else{
		return false;
	}
	
	
}
