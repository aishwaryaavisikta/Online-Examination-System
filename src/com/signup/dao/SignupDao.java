package com.signup.dao;
import java.sql.*;

import com.signup.pojo.SignupPojo;

public class SignupDao {
	String url ="jdbc:mysql://localhost/oes";
	String username="root";
	String password="root";
	String driver="com.mysql.jdbc.Driver";
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
		
	public int save(SignupPojo pojo)
	{
		// TODO Auto-generated method stub
		int userid=0;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
			System.out.println("CONNECTED");
			st=con.createStatement();
			String query="INSERT INTO login(email,password,type) VALUES ('" + pojo.getEmail() + "', '" +pojo.getPassword()+"','"+"student"+ "')";
			System.out.println(query);
			st.executeUpdate(query);
			String query2="select * from login where email='"+ pojo.getEmail() +"'and password='"+ pojo.getPassword()+"'";
			System.out.println(query2);
			rs=st.executeQuery(query2);
			while(rs.next())
			{
				userid=rs.getInt("userid");
			}
			String query1="INSERT INTO student(firstname,lastname,email,batch,branch,phoneno,password,gender,userid) VALUES "
					+ "('"+pojo.getFirstname()+ "','" + pojo.getLastname()+ "','" + pojo.getEmail() +"'," + pojo.getBatch() +",'"
					+pojo.getBranch()+"','" + pojo.getPhoneno() + "','" + pojo.getPassword()+"','" + pojo.getGender()+ "',"
					+userid+")";
			System.out.println(query1);
			st.executeUpdate(query1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
			return userid;
		}

}
