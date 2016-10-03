package com.addsubject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.addbranch.pojo.AddBranchPojo;
import com.addsubject.pojo.AddSubjectPojo;

public class AddSubjectDao {
	String Driver="com.mysql.jdbc.Driver";
	String user="root";
	String password="root";
	String url="jdbc:mysql://localhost:3306/oes";
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	public int addSubject(AddSubjectPojo pojo) {
		// TODO Auto-generated method stub
	int subjectid=0;
	try
	{
		Class.forName(Driver);
		con=DriverManager.getConnection(url,user,password);
		st=con.createStatement();
		String qry="insert into subject(branchid,subjectcode,subjectname) values ("+pojo.getBranchid()+",'"
							+pojo.getSubjectcode()+"','"+pojo.getSubjectname()+"')";
		System.out.println(qry);
		st.executeUpdate(qry);
		String qry1="select subjectid from subject where subjectcode='"+pojo.getSubjectcode()+"'";
		System.out.println(qry1);
		rs=st.executeQuery(qry1);
		while(rs.next())
		{
			subjectid=rs.getInt("subjectid");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return subjectid;

		
	}
		public int checkSubject(AddSubjectPojo pojo) {
			// TODO Auto-generated method stub
			int subjectid=0;
			try{
				Class.forName(Driver);
				con=DriverManager.getConnection(url,user,password);
				st=con.createStatement();
				String qry1="select subjectid from subject where subjectcode='"+pojo.getSubjectcode()+"'";
				System.out.println(qry1);
				rs=st.executeQuery(qry1);
				while(rs.next())
				{
					subjectid=rs.getInt("subjectid");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return subjectid;
		}


}
