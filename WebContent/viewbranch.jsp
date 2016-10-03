<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,javax.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>viewbranch</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
    <%
	int userid=Integer.parseInt(session.getAttribute("userid").toString());
	session.setAttribute("userid", userid);
	System.out.println(userid);
	%>
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
     <div><h2 align="center"><font face="Monotype Corsiva" color="3300CC"><b>ALL BRANCHES</b></font></h2></div>
		<%String msg=(String)request.getAttribute("msg");
		if(msg!= null)
		{%>
		<font color="blue"><%=msg%></font>
		
		<%}%>
		   <div class="container">
            <p>&nbsp;</p><div class="col-lg-6 col-lg-offset-6">
            <input type="search" name="search" id="search" value="" class="form-control" placeholder="Search Contacts">
        </div><table class="table" cellpadding="10" id="tblData">
         
                <tbody> 
				 <tr id ="border" align="">
						<td align="left" valign="middle"><u><b>Sl.No</b></u></td>
<td  align="left"><u><b>BRANCH</b></u></td>
<td align="left"><u><b></b></u></td>
<td></td>	
                    </tr>
                    
		<%
			ResultSet rs=(ResultSet)session.getAttribute("rs");
			Statement st=(Statement)session.getAttribute("st");
			int countpage=0;
			int count=1;
			
			while(rs.next())
			{
			%>
<tr id="border1"><font color="black">	
<td align="left" ><font color="black"><%=count++%></font></td>
<td align="left"><font color="black"><%=rs.getString("branchname") %></font></td>

<td align="left" ><form name="submitForm" method="POST" action="DeleteBranch?branchid=<%=rs.getInt("branchid")%>">
                    			<button><img src="images/delete.png" height="25px" width="25px"></button></form></td>
<td></td>
</tr>		
              <%}
			String qry1="select count(*) from branch";
			rs=st.executeQuery(qry1);
			while(rs.next())
			{
				countpage=rs.getInt("count(*)");
			}
			int pages=(countpage/10)+1; %>
			 </tbody>
			</table>
			 <hr>
			<table><tr>	<td>Page:</td>
			<%
			for(int i=1;i<=pages;i++)
			{
			%>
			<td><u><form name="submitForm" method="POST" action="ViewBranch?page=<%=i%>">
                    			<button><b><%=i %></b></button></form></u></td>
			<%
			}%>
			
               
            </table>
           
	</form>  </div>  
</body>
</html>
