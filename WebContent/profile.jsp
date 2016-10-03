<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true" import="java.sql.*,javax.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>profile</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/clock.js"></script>
	<script src="js/profile.js"></script>
	<%
	int userid=Integer.parseInt(session.getAttribute("userid").toString());
	session.setAttribute("userid", userid);
	System.out.println(userid+"hi");
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

        <div>
			<h2 align="center"><font face="Monotype Corsiva" color="3300CC"><b>PROFILE</b></font></h2></div>
			<form name="profile" id="profile" method="post" action="manageredit.jsp" onsubmit="return profilevalidate()">
			<%
				ResultSet rs=(ResultSet)session.getAttribute("rs");
				while(rs.next())
				{
			%>
<center>
<div id="detail">
<table class="table table-striped" id="tbldata">
<tr>
<td><label><b><font color="black">Name:</font><td></td></td>
<td></b></label><%=rs.getString("firstname") %> <%=rs.getString("lastname") %></td>
</tr>
<tr>
<td><label><b><font color="black">Email:</font><td></td></td>
<td></b></label><%=rs.getString("email") %></td>
</tr>
<tr>
<td><label><b><font color="black">upload photo:</font></b><td></td></td>
<td></label><input type="file" name="filefield" id="filefield" size="40"></td>
</tr>
<tr>
<td><label><b><font color="black">Phone no:</font></b><td></td></td>
<td></label><%=rs.getString("phoneno") %></td>
</tr>
<tr>
<td></td><td align="right"><input type="submit" name="edit" id="edit" value="EDIT" size="30" ></td><td></td>
</tr>
<% }%>
</table>
</div>
</center>
</form>  
</body>
</html>
