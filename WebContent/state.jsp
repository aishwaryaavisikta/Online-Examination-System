<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*,javax.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String name=request.getParameter("name") ;
try
{
	String Driver="com.mysql.jdbc.Driver";
	String user="root";
	String password="root";	
	String url="jdbc:mysql://localhost/lit";
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String qry="select * from state where name=?";
	Class.forName(Driver);
	con=DriverManager.getConnection(url,user,password);
	pst=con.prepareStatement(qry);
	pst.setString(1, name);
	rs=pst.executeQuery();
	out.print("<select id='dist' name='dist'>");
	System.out.println("CONNECTED");
	while(rs.next())
	{	
		out.print("<option>"+rs.getString(2)+"</option>");
	}
	out.print("</select>");
}
catch(Exception e)
{
	e.printStackTrace();
}


%>
</body>
</html>