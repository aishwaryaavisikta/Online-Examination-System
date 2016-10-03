package com.login.dao;

import com.login.pojo.LoginPojo;
import java.sql.*;

public class LoginDao {
	String url ="jdbc:mysql://localhost/oes";
	String username="root";
	String password="root";
	String driver="com.mysql.jdbc.Driver";
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	int userid=0;
	public int loginuser(LoginPojo pojo)
	{// TODO Auto-generated method stub
		try
	    {
			Class.forName(driver);		         
			con = DriverManager.getConnection(url,username,password);
		    //System.out.println("CONNECTED");
		    st = con.createStatement();
		    String qry="select * from login where email='" + pojo.getEmail() +"'and password= '" + pojo.getPassword()+"'";
		    System.out.println(qry);
		    rs=st.executeQuery(qry);
		    while(rs.next())
		    {
		    	userid=rs.getInt("userid");
		    }
		    rs.close();
		    st.close();
		    con.close();           
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
		return userid;
	      
	}
	public int loginManager(LoginPojo pojo) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName(driver);		         
			con = DriverManager.getConnection(url,username,password);
		    System.out.println("CONNECTED");
		    st = con.createStatement();
		    String qry="select * from login where email='" + pojo.getEmail() +"'and password= '" + pojo.getPassword()+"'";
		    System.out.println(qry);
		    rs=st.executeQuery(qry);
		    while(rs.next())
		    {
		    	userid=rs.getInt("userid");
		    	System.out.println(userid);
		    }
		    rs.close();
		    st.close();
		    con.close(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return userid;
	}

}
