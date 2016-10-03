package com.forgetpassword.dao;
import java.sql.*;

import com.forgetpassword.pojo.ForgetPasswordPojo;


public class ForgetPasswordDao {
	String url ="jdbc:mysql://localhost/oes";
	String username="root";
	String password="root";
	String driver="com.mysql.jdbc.Driver";
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	String password1=null;
	public String findPassword(ForgetPasswordPojo pojo) 
	{// TODO Auto-generated method stub
		try
	    {
			Class.forName(driver);		         
			con = DriverManager.getConnection(url,username,password);
		    System.out.println("CONNECTED");
		    st = con.createStatement();
		    String qry="select * from login where email='" + pojo.getEmail()+"'";
		    System.out.println(qry);
		    rs=st.executeQuery(qry);
		    while(rs.next())
		    {
		    	password1=rs.getString("password");
		    }
		    rs.close();
		    st.close();
		    con.close();           
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
		return password1;
		
	}

}
