package com.addquestion.dao;

import com.addquestion.pojo.AddQuestionPojo;
import java.sql.*;

public class AddQuestionDao {

	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	int questionid=0;

	String url="jdbc:mysql://localhost:3306/oes";
	String username="root";
	String password="root";
	public void addquestion(AddQuestionPojo pojo)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("CONNECTED");
			st=con.createStatement();
			String query="INSERT INTO question(answer,question,subjectid) VALUES ('"+pojo.getAnswer()+"','"+pojo.getQuestion()+ "',"+pojo.getSubjectid()+")";
			System.out.println(query);
			st.executeUpdate(query);
			String qry1="select * from question where question='"+pojo.getQuestion()+"' and answer='"+pojo.getAnswer()+"'";
			rs=st.executeQuery(qry1);
			System.out.println(qry1);
			while(rs.next())
			{
				questionid=rs.getInt("questionid");
				System.out.println(questionid);
			}
		
					String qry2="INSERT INTO questionoption(quesoption,questionid) VALUES ('"+pojo.getOption1()+ "',"+questionid+")";
					
					System.out.println(qry2);
					st.executeUpdate(qry2);
					String qry3="INSERT INTO questionoption(quesoption,questionid) VALUES ('"+pojo.getOption2()+ "',"+questionid+")";
					st.executeUpdate(qry3);
					String qry4="INSERT INTO questionoption(quesoption,questionid) VALUES ('"+pojo.getOption3()+ "',"+questionid+")";
					st.executeUpdate(qry4);
					String qry5="INSERT INTO questionoption(quesoption,questionid) VALUES ('"+pojo.getOption4()+ "',"+questionid+")";
					st.executeUpdate(qry5);
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					System.out.println("Printted");
				}
			}
	public int checkquestion(AddQuestionPojo pojo )
	{
		int questionid = 0;
		try
		{
			final String url="jdbc:mysql://localhost/oes";
			final String username="root";
			final String password="root";
	
	
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			System.out.println("CONNECTED");
			st=con.createStatement();
			
			String qry="select * from question where question='" +pojo.getQuestion()+ "'";
	        System.out.println(qry);
	        rs=st.executeQuery(qry);
	           
	           while(rs.next())
	           {
	        	   questionid = rs.getInt("questionid");
	        	   
	           }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}			
		return questionid;
	}

}
