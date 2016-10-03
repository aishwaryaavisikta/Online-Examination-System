<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,javax.sql.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>studentlist</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/clock.js"></script>

    
	<script>
$(document).ready(function()
{
	$('#search').keyup(function()
	{
		searchTable($(this).val());
	});
});

function searchTable(inputVal)
{
	var table = $('#tblData');
	table.find('tr').each(function(index, row)
	{
		var allCells = $(row).find('td');
		if(allCells.length > 0)
		{
			var found = false;
			allCells.each(function(index, td)
			{
				var regExp = new RegExp(inputVal, 'i');
				if(regExp.test($(td).text()))
				{
					found = true;
					return false;
				}
			});
			if(found == true)$(row).show();
				else $(row).hide();
		}
	});
}
</script>
<%
	int userid=Integer.parseInt(session.getAttribute("userid").toString());
	session.setAttribute("userid", userid);
	System.out.println(userid);
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
                <div class="col-lg-12">
                   
  <div id="inner-page">
    <div><h2 align="center"><font face="Monotype Corsiva" color="3300CC"><b>STUDENT LIST</b></font></h2></div>
		   <div class="container">
            <p>&nbsp;</p><div class="col-lg-6 col-lg-offset-6">
            <input type="search" name="search" id="search" value="" class="form-control" placeholder="Search Contacts">
        </div><table class="table" cellpadding="10" id="tblData">
         <%String msg=(String)request.getAttribute("msg");
		if(msg!= null)
		{%>
		<font color="blue"><%=msg%></font>
		
		<%}%>
                <tbody> 
				 <tr id ="border" align="center">
						<td align="left" valign="middle"><u><b>Sl.No</b></u></td>
<td align="left"  valign="left"><u><b>NAME</b></u></td>
<td align="left"  valign="left"><u><b>EMAIL</b></u></td>
<td align="left"  valign="left"><u><b>BRANCH</b></u></td>
<td></td>
	
                    </tr>
                    
		<%try{
		Statement st=(Statement)session.getAttribute("st");
		ResultSet rs=(ResultSet)session.getAttribute("rs");
		
		int count=1;
		int countpage=0;			
		while(rs.next())
		{
			%>
		<tr id="border1">	
			<td align="left" valign="left"><%=count++%></td>
			<td align="left" valign="left"><%=rs.getString("firstname") %> <%=rs.getString("lastname") %></td>
			<td align="left" valign="left"><%=rs.getString("email") %></td>
			<td align="left" valign="left"><%=rs.getString("branch") %></td>
			<td align="left" valign="left" ><form name="submitForm" method="POST" action="StudentProfile?studentid=<%=rs.getInt("studentid")%>">
                    <button><font color="black">VIEW</font></button></form></td>
		</tr>		
     <%	}
		String qry1="select count(*) from student";
		rs=st.executeQuery(qry1);
		while(rs.next())
		{
			countpage=rs.getInt("count(*)");
		}
		int pages=(countpage/10)+1; %>
		</table>
		<table><tr>
			
		<%
		for(int i=1;i<=pages;i++)
		{
		%>
		<td><b><u><form name="submitForm" method="POST" action="StudentList?page=<%=i%>">
                    <button><font color="black"><%=i %></font></button></form></u></b></td>
		<%
		}%>
		</tr><%
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		%>     
                </tbody>
            </table>
            <hr>
	</form>
	</div> 
</body>
</html>
