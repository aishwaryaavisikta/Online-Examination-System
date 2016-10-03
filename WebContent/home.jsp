<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/clock.js"></script>
	<script src="js/addbranch.js"></script>
	<% int userid=Integer.parseInt(session.getAttribute("userid").toString());
	session.setAttribute("userid", userid); 
	%>
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
					<li class="active"><a href="home.jsp"><i class="fa fa-home fa-fw"></i>   HOME</a></li>
					<li><form name="submitForm" method="POST" action="Profile"><i class="fa fa-pencil fa-fw"></i>
                    			<button>PROFILE</button></form></li>
                    <li><form name="submitForm" method="POST" action="StudentList?page=1">
                    			<button><i class="fa fa-book fa-fw"></i> STUDENT LIST</button></form></li>
                    <li><form name="submitForm" method="POST" action="addbranch.jsp">
                    			<button><i class="fa fa-pencil fa-fw"></i>ADD BRANCH</button></form></li>
                    <li><form name="submitForm" method="POST" action="SelectBranch">
                    			<button><i class="fa fa-pencil fa-fw"></i>ADD SUBJECT</button></form></li>
                    <li><form name="submitForm" method="POST" action="SelectSub">
                    			<button><i class="fa fa-pencil fa-fw"></i>ADD QUESTION</button></form></li>
                    <li><form name="submitForm" method="POST" action="Exam">
                    			<button><i class="fa fa-pencil fa-fw"></i>ADD EXAM</button></form></li>
                    <li><form name="submitForm" method="POST" action="ViewBranch?page=1">
                    			<button><i class="fa fa-pencil fa-fw"></i>VIEW BRANCH</button></form></li>  
                    <li><form name="submitForm" method="POST" action="ViewSubject">
                    			<button><i class="fa fa-book fa-fw"></i> VIEW SUBJECT</button></form></li>                    
     				<li><form name="submitForm" method="POST" action="ViewQuestion">
                    			<button><i class="fa fa-book fa-fw"></i> VIEW QUESTION</button></form></li> 
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
                <div class="">
				
            </div>
        </div>
    </div>
</body>
</html>
