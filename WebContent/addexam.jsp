<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,javax.sql.*,com.addexam.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>addexam</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/clock.js"></script>
	<script src="js/addexam.js"></script>
	<% int userid=Integer.parseInt(session.getAttribute("userid").toString());
	session.setAttribute("userid", userid); 
	%>
	<script type="text/javascript">
	function call()
	{
		//alert("hello");
	    var obj;
		var branchid=document.getElementById("branchid").value;
		alert(branchid);
		var url="CheckSubject2?branchid="+branchid;
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
			else
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
                   
				<div id="inner-page" style="height:400px">
     <div><h2 align="center"><font face="Monotype Corsiva" color="3300CC"><b>ADD EXAM</b></font></h2></div>
		<form name="addexam" id="addexam" method="post" action="AddExamQuestion" onsubmit="return examvalidate()">
		<%ResultSet rs=(ResultSet)session.getAttribute("rs"); %>
<center>
<div id="detail">
<table class="table table-striped">
<tr>
<td><label><b>CHOOSE BRANCH</b></label></td>
<td><select name="branchid" id="branchid" onchange="call()">
<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--SELECT--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%while(rs.next())
	{%><option value="<%=rs.getInt("branchid")%>"><%=rs.getString("branchname")%></option>
	<%} %></select>
	
</td>
</tr>
<tr>
<td><label><b>CHOOSE SUBJECT</b></label></td>

<td><span id="result"></span></td>
</tr>
<tr>
<td><label><b>TOTAL MARK:</b></label></td>
<td></label><input type="number" name="totalmark" id="totalmark" size="40"></td>
</tr>
<tr>
<td><label><b>TIME:</b></label></td>
<td></label><input type="number" name="time" id="time" size="40"></td>
</tr>
<tr>
<td><label><b>TOTAL QUESTION:</b></label></td>
<td></label><input type="number" name="totalquestion" id="totalquestion" size="40"></td>
</tr>
<tr>
<td><label><b>DATE:</b></label></td>
<td></label><input type="date" name="date" id="date" value="date(Y-m-d)" size="40"></td>
<script>
$(function(){
  $("#calender").datepicker();
  });
  </script>
</tr>
<tr>
<td></td><td><input type="submit" name="save" id="save" value="NEXT-->" size="30"></td>
</tr>
</table>
</div>
</center>
</form>
  </div>  
</body>
</html>
