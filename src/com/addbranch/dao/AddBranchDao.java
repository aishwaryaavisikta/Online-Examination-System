package com.addbranch.dao;

import com.addbranch.pojo.AddBranchPojo;

import java.sql.*;

public class AddBranchDao {
	
	String Driver="com.mysql.jdbc.Driver";
	String user="root";
	String password="root";
	String url="jdbc:mysql://localhost:3306/oes";
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	
	public int addBranch(AddBranchPojo pojo) {
		// TODO Auto-generated method stub
		int branchid=0;
		try{
			Class.forName(Driver);
			con=DriverManager.getConnection(url,user,password);
			st=con.createStatement();
			String qry="insert into branch(branchname) values ('"+pojo.getBranchname()+"')";
			System.out.println(qry);
			st.executeUpdate(qry);
			String qry1="select branchid from branch where branchname='"+pojo.getBranchname()+"'";
			System.out.println(qry1);
			rs=st.executeQuery(qry1);
			while(rs.next())
			{
				branchid=rs.getInt("branchid");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return branchid;
	}

	public int checkbranch(AddBranchPojo pojo) {
		// TODO Auto-generated method stub
		int branchid=0;
		try{
			Class.forName(Driver);
			con=DriverManager.getConnection(url,user,password);
			st=con.createStatement();
			String qry1="select branchid from branch where branchname='"+pojo.getBranchname()+"'";
			System.out.println(qry1);
			rs=st.executeQuery(qry1);
			while(rs.next())
			{
				branchid=rs.getInt("branchid");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return branchid;

	}

}
