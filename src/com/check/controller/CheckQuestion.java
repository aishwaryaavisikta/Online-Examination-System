package com.check.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.question.pojo.QuestionPojo;

/**
 * Servlet implementation class CheckQuestion
 */
@WebServlet("/CheckQuestion")
public class CheckQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int subjectid=Integer.parseInt(request.getParameter("subjectid"));
		System.out.println(subjectid);
			
		out.print("<table class='table' cellpadding='10' id='tblData'>");      
        out.print("<tbody>"); 
		out.print("<tr id ='border' align=''>");
		out.print("<td align='left' valign='middle'><u><b>Sl.No</b></u></td>");
		out.print("<td  align='left'><u><b>QUESTION</b></u></td>");
		out.print("<td align='left'><u><b>ANSWER</b></u></td>");
		out.print("<td></td>");
		out.print("<td></td>");
		out.print("<td></td>");
		out.print("<td></td>");
		out.print("<td></td>");
		out.print("<td></td>");
        out.print("</tr>");
        
        try
        {	
        	String url ="jdbc:mysql://localhost:3306/oes";
        	String driver="com.mysql.jdbc.Driver";
        	Connection con=null;
        	Statement st=null;
        	ResultSet rs=null;
			Class.forName("com.mysql.jdbc.Driver");
			int count=1;

			con=DriverManager.getConnection(url,"root","root");
			System.out.println("CONNECTED");
			st=con.createStatement();
   
        	String qry1="select * from question where subjectid="+subjectid+" order by questionid" ;
			System.out.println(subjectid);
			System.out.println(qry1);
			rs=st.executeQuery(qry1);
			 ArrayList<QuestionPojo> list = new ArrayList<QuestionPojo>();
			
			while(rs.next())
			{	
				
				String question=rs.getString("question");
				System.out.println(question);
				String answer=rs.getString("answer");
				QuestionPojo pojo= new QuestionPojo();
				pojo.setAnswer(answer);
				pojo.setQuestionid(rs.getInt("questionid"));
				pojo.setQuestion(rs.getString("question"));
				list.add(pojo);
			}
			for (int i=0;i<list.size();i++)
	        {	
				System.out.println(i);
				System.out.println(list.size());
				list.get(i);
				
				QuestionPojo pojo=list.get(i);
				System.out.println(i+""+pojo.getQuestion());
				out.print("<tr id='border1'><font color='black'>");	
				out.print("<td align='left' ><font color='black'>"+count++ +"</font></td>");
				out.print("<td align='left'><font color='black'>"+pojo.getQuestion()+"</font></td>");
				out.print("<td align='left'><font color='black'>"+pojo.getAnswer()+"</font></td>");
				
							
				String qry2="select * from questionoption where questionid="+pojo.getQuestionid();
				System.out.println(pojo.getQuestionid());
				System.out.println(qry2);
				rs=st.executeQuery(qry2);
				int count1=1;
				
				//out.print("<tr id='border1'><font color='black'>");
				while(rs.next())
				{	
					pojo.setOption(rs.getString("quesoption"));
					System.out.println(pojo.getOption());
					out.print("<td align='left'><font color='black'>Option "+count1++ +":  "+pojo.getOption()+"</font></td>");
					
					
				}
				out.print("<td align='left' ><form name='submitForm' method='POST' action='DeleteQuestion?questionid="+pojo.getQuestionid()+"'><button><img src='images/delete.png' height='25px' width='25px'></button></form></td>");
				//out.print("<tr>");
				System.out.println(pojo.getQuestionid());
	        
						out.print("</tr>");	
	        }
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	     
       out.print(" </tbody>    </table>");
		
		

	}

}
