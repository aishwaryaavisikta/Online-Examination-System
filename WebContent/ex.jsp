<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*,javax.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
function call()
{
    var obj;
	var name=document.getElementById("name").value;
	//alert(name);
	var url="state.jsp?name="+name;
	//alert(url);
    if(window.XMLHttpRequest)	//except IE
		{
			obj=new XMLHttpRequest();
		}
	else	//IE	
		{
			obj=new ActiveXObject("Microsoft.XMLHTTP");
		}
	obj.open("get",url,true);	//get/post,target(jsp,html,txt,servlet),false-asyncronus
	obj.send();
	obj.onreadystatechange=function()
	{
		if (obj.readyState==4 && obj.status==200)
			{
				document.getElementById("dist").innerHTML=obj.responseText;
			}
	} 
}
</script>
</head>
<body>
<%try
{
	String Driver="com.mysql.jdbc.Driver";
	String user="root";
	String password="root";	
	String url="jdbc:mysql://localhost/lit";
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String qry="select * from state";
	Class.forName(Driver);
	con=DriverManager.getConnection(url,user,password);
	pst=con.prepareStatement(qry);
	rs=pst.executeQuery();
	out.print("<select id='name' name='name' onKeyup='call()'>");
	System.out.println("CONNECTED");
	while(rs.next())
	{	
		out.print("<option>"+rs.getString(1)+"</option>");
	}
	out.print("</select>");
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
<br><span id="dist"></span>
</body>
</html>