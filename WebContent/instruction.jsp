<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>instruction</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
    <% int userid=Integer.parseInt(session.getAttribute("userid").toString());
	session.setAttribute("userid", userid); 
	%>
	<script src="js/clock.js"></script>
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
				<div class="logo" align="left">
					<img src="images/logo1.png" alt=""/>
				</div>
                <a class="navbar-brand" href="index.jsp">ONLINE EXAMINATION SYSTEM</a>
				
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
					<li class="active"><a href="instruction.jsp"><i class="fa fa-home fa-fw"></i>   INSTRUCTION</a></li>
					<li><a href="s_profile.jsp"><i class="fa fa-user fa-fw"></i>   PROFILE</a></li>
                    <li><a href="onlinetest.jsp"><i class="fa fa-pencil fa-fw"></i>    ONLINE TEST</a></li>					
                </ul>
                 <ul class="nav navbar-nav navbar-right navbar-user">
					<div class="nav navbar-nav navbar-right navbar-user">
					<a class="btn btn-primary" href="s_profile.jsp"><i class="fa fa-user fa-fw"></i> User</a>
					<a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
					<span class="fa fa-caret-down" title="Toggle dropdown menu"></span>
					</a>
					
					<ul class="dropdown-menu">
                           <li class="divider"></li>
                            <li class="message-preview">
                                <a href="changepassword1.jsp">
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
                <div class="">
				
          <div id="inner-page">

        <div>
			<h2 align="center"><font face="Monotype Corsiva" color="3300CC"><b>INSTRUCTION</b></font></h2></div>
			<form name="profile" id="profile" method="post" action="" onsubmit="return profilevalidate()">

<div id="detail">
<table class="table table-striped" id="tbldata"><b>
<tr><td><b>1. Make sure you have good internet connection.</b></td></tr>
<tr><td><b>2. Shut down all Instant Messaging tools(Skype, Gmail, Facebook)</b></td></tr>
<tr><td><b>3. Donot resize the browser during test.</b></td></tr>
<tr><td><b>4. Click the "Submit" button to submit your exam.</b></td></tr>
<tr><td><b>5. Answer all the question in the exam.</b></td></tr>
<tr><td></td></tr>
	
</table>
</div>

</form>  
</body>
</html>

        
