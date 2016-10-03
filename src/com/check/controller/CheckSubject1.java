package com.check.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class CheckSubject1
 */
@WebServlet("/CheckSubject1")
public class CheckSubject1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int branchid=Integer.parseInt(request.getParameter("branchid"));
		System.out.println(branchid);
			
		out.print("<table class='table' cellpadding='10' id='tblData'>");      
        out.print("<tbody>"); 
		out.print("<tr id ='border' align=''>");
		out.print("<td align='left' valign='middle'><u><b>Sl.No</b></u></td>");
		out.print("<td  align='left'><u><b>BRANCH</b></u></td>");
		out.print("<td align='left'><u><b></b></u></td>");
		out.print("<td></td>");	
        out.print("</tr>");
        
        try
        {	
        	String url ="jdbc:mysql://localhost:3306/oes";
        	String driver="com.mysql.jdbc.Driver";
        	Connection con=null;
        	Statement st=null;
        	ResultSet rs=null;
        	int totalpage=8;
        	int countpage=0;
        	/*int counter=Integer.parseInt(request.getParameter("page").toString());
        	if(counter==1)
        	{
        		counter=counter-1;
        	}
        	else
        	{
        		counter=counter-1;
        		counter=counter*totalpage;
        	}*/
				
        	String query="select * from subject where branchid="+branchid;//+"limit "+counter+","+totalpage+"";
			Class.forName(driver);
			con=DriverManager.getConnection(url,"root", "root");
			st=con.createStatement();
			rs=st.executeQuery(query);
			int count=1;
	
			while(rs.next())
			{
				out.print("<tr id='border1'><font color='black'>");	
				out.print("<td align='left' ><font color='black'>"+count++ +"</font></td>");
				out.print("<td align='left'><font color='black'>"+rs.getString("subjectname") +"</font></td>");
				out.print("<td align='left' ><form name='submitForm' method='POST' action='DeleteSubject?subjectid="+rs.getInt("subjectid")+"'><button><img src='images/delete.png' height='25px' width='25px'></button></form></td>");
				out.print("<td></td>");
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
