package com.editprofile.dao;

import com.editprofile.pojo.EditProfilePojo;

import java.sql.*;

public class EditProfileDao {
		Connection con=null;
		ResultSet rs = null; 
		Statement st=null;
		 String url ="jdbc:mysql://localhost/oes";
		 String driver="com.mysql.jdbc.Driver";
		
		public int updateManager(EditProfilePojo pojo) throws Exception {
		// TODO Auto-generated method stub
			int userid=0;
		try
		{
			Class.forName(driver);     
			con = DriverManager.getConnection(url,"root","root");
			System.out.println("CONNECTED");
			st = con.createStatement();
			String qry="SELECT * from manager where userid="+pojo.getUserid();
			System.out.println(qry);
			rs=st.executeQuery(qry);       
			/**/
			while(rs.next())
			{
				userid=rs.getInt("userid");
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
	    }
	   return userid;
	  }
	   public int update(EditProfilePojo pojo) throws Exception
	   {
	     
	      try
	      {
		
	         Class.forName(driver);
	         con = DriverManager.getConnection(url,"root","root");
	         System.out.println("CONNECTED");
	           st = con.createStatement();
	           String qry=  "update login set  email='"+pojo.getEmail()+"' where userid='"+pojo.getUserid()+"'";
	           System.out.println(qry);
		  
	           String qry1=  "update manager set firstname='"+pojo.getFirstname()+"', lastname='"+pojo.getLastname()+"', email='"+pojo.getEmail()+"',phoneno='"+pojo.getPhoneno()+"' where userid='"+pojo.getUserid()+"'";
	           System.out.println(qry1);
	           st.executeUpdate(qry1); 
	        
	           
	         }
	         
	         catch (SQLException e)
	         {
	            e.printStackTrace();
	         }
	      

		return 0;
	}

}
