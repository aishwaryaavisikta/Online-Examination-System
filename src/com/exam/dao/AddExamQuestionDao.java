package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

import com.exam.pojo.AddExamQuestionPojo;

public class AddExamQuestionDao {

	public int saveExam(AddExamQuestionPojo pojo) {
		// TODO Auto-generated method stub
		String url ="jdbc:mysql://localhost:3306/oes";
		String driver="com.mysql.jdbc.Driver";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int examid=0;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			String query="insert into exam(date,totalmark,time,totalquestion,subjectid) values('"+pojo.getDate()+"',"
								+pojo.getTotalmark()+","+pojo.getTime()+","+pojo.getTotalquestion()+","+pojo.getSubjectid()+")";
			st.executeUpdate(query);
			String query1="select * from exam where totalmark="+pojo.getTotalmark()+" and subjectid="+pojo.getSubjectid();
			System.out.println(query1);
			rs=st.executeQuery(query1);
			while(rs.next())
			{
				examid=rs.getInt("examid");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return examid;
		
	}

}
