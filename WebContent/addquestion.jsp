<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,javax.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>addquestion</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/clock.js"></script>
	<!-- <script src="js/pra3.js"></script> -->
	<%
	int userid=Integer.parseInt(session.getAttribute("userid").toString());
	session.setAttribute("userid", userid);
	System.out.println(userid);
	int subjectid=Integer.parseInt(request.getParameter("subjectid"));
	System.out.println(subjectid);
	
	%>
<script type="text/javascript">
function call()
{
    var obj;
	var branchid=document.getElementById("branchid").value;
	if(branchid==null)
	{
		document.getElementById("result1").innerHTML="SELECT A BRANCH";
	}
	else
	{
		document.getElementById("result1").innerHTML="";
	}
	//alert(name);
	var url="SelectSubject?branchid="+branchid;
	//alert(url);
    if(window.XMLHttpRequest)	//except IE
		{
			obj=new XMLHttpRequest();
		}
	else	//IE	
		{
			obj=new ActiveXObject("Microsoft.XMLHTTP");
		}
	obj.open("post",url,true);	//get/post,target(jsp,html,txt,servlet),false-asyncronus
	obj.send();
	obj.onreadystatechange=function()
	{
		if (obj.readyState==4 && obj.status==200)
			{
				document.getElementById("result").innerHTML=obj.responseText;
			}
	} 
}

</script>	

    
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
				<div class="logo">
				<img src="images/logo1.png" alt=""/>
			</div>
                <a class="navbar-brand" href="index.jsp">ONLINE EXAMINATION SYSTEM</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
					<li class="active"><a href="home.jsp"><i class="fa fa-home fa-fw"></i>   HOME</a></li>
					<li><form name="submitForm" method="POST" action="Profile"><i class="fa fa-pencil fa-fw"></i>
                    			<button>PROFILE</button></form></li>
                    <li><form name="submitForm" method="POST" action="StudentList?page=1"><i class="fa fa-pencil fa-fw"></i>
                    			<button>STUDENT LIST</button></form></li>
                    <li><form name="submitForm" method="POST" action="addbranch.jsp"><i class="fa fa-pencil fa-fw"></i>
                    			<button>ADD BRANCH</button></form></li>
                    <li><form name="submitForm" method="POST" action="SelectBranch"><i class="fa fa-pencil fa-fw"></i>
                    			<button>ADD SUBJECT</button></form></li>
                    <li><form name="submitForm" method="POST" action="SelectSub"><i class="fa fa-pencil fa-fw"></i>
                    			<button>ADD QUESTION</button></form></li>
                    <li><form name="submitForm" method="POST" action="Exam"><i class="fa fa-pencil fa-fw"></i>
                    			<button>ADD EXAM</button></form></li>
                    <li><form name="submitForm" method="POST" action="ViewBranch?page=1"><i class="fa fa-pencil fa-fw"></i>
                    			<button>VIEW BRANCH</button></form></li>  
                    <li><form name="submitForm" method="POST" action="ViewSubject"><i class="fa fa-pencil fa-fw"></i>
                    			<button>VIEW SUBJECT</button></form></li>                    
     				<li><form name="submitForm" method="POST" action="ViewQuestion"><i class="fa fa-pencil fa-fw"></i>
                    			<button>VIEW QUESTION</button></form></li> 
                    <li><a href="viewexam.jsp"><i class="fa fa-book fa-fw"></i>   VIEW EXAM</a></li> 			
                </ul>
                 <ul class="nav navbar-nav navbar-right navbar-user">
					<div class="nav navbar-nav navbar-right navbar-user">
					<a class="btn btn-primary" href="profile.jsp"><i class="fa fa-user fa-fw"></i> User</a>
					<a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
					<span class="fa fa-caret-down" title="Toggle dropdown menu"></span>
					</a>
					
					<ul class="dropdown-menu">
							<li class="message-preview">
                                <a href="profile.jsp">
                                    <span class="avatar"><i class="fa fa-user fa-fw"></i></span>
                                    <span class="message">Edit Profile</span>
                                </a>
                            </li>
                           <li class="divider"></li>
                            <li class="message-preview">
                                <a href="changepassword.jsp">
                                    <span class="avatar"><i class="fa fa-cog"></i></span>
                                    <span class="message">Change Password</span>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li class="message-preview">
                                <a href="index.jsp">
                                    <span class="avatar"><i class="fa fa-power-off"></i></span>
                                    <span class="message">Logout</span>
                                </a>
                            </li>
                            
                        </ul>
					</div>
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                   
				<div id="inner-page">
     <div><h2 align="center"><font face="Monotype Corsiva" color="3300CC"><b>ADD QUESTION</b></font></h2></div>
		<form name="insertqsn" id="insertqsn" method="post" action="AddQuestion" onsubmit="return option()">
<center>
<div id="detail">
<table class="table table-striped">
<tr>
<td><label><b>QUESTION:</b></label></td>
<td><input type="text" name="question" id="question" size="80"></td>
</tr>
<tr>
<td><label><b>OPTION:</b></label></td><td></td>
</tr>
<tr>
<td>A:</td><td><input type="text" name="option1" id="option1" size="40" onblur="call()"></td><td><input type="checkbox" name="ans" id="ans" value="option1" ></td>
</tr>
<tr>
<td>B:</td><td><input type="text" name="option2" id="option2" size="40" onblur="call()"></td><td><input type="checkbox" name="ans" id="ans" value="option2" ></td>
</tr>
<tr>
<td>C:</td><td><input type="text" name="option3" id="option3" size="40" onblur="call()"></td><td><input type="checkbox" name="ans" id="ans" value="option3" ></td>
</tr>
<tr>
<td>D:</td><td><input type="text" name="option4" id="option4" size="40" onblur="call()"></td><td><input type="checkbox" name="ans" id="ans" value="option4" ></td>
</tr>
<tr>
<td></td>
<td><input type="hidden" name="subjectid" id="subjectid" size="40" value="<%=subjectid%>"></td>
</tr>
<tr>
<td></td><td><input type="submit" name="save" id="save" value="SAVE"  size="30"></td>
</tr>
</form>
</table>
</div>
</center> 
</body>
</html>
