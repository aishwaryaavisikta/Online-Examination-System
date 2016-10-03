package com.addsubject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addsubject.dao.AddSubjectDao;
import com.addsubject.pojo.AddSubjectPojo;

/**
 * Servlet implementation class AddSubject
 */
@WebServlet("/AddSubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		int branchid=Integer.parseInt(request.getParameter("branchid"));
   		String subjectcode=request.getParameter("subjectcode");
   		String subjectname=request.getParameter("subjectname");
   		
   		AddSubjectPojo pojo=new AddSubjectPojo();
   		pojo.setBranchid(branchid);
   		pojo.setSubjectcode(subjectcode);
   		pojo.setSubjectname(subjectname);
   		
   		AddSubjectDao dao=new AddSubjectDao();
   		int subjectid=dao.checkSubject(pojo);
   		if(subjectid==0)
   		{
   			int subjectid1=dao.addSubject(pojo);
   			if(subjectid1!=0)
			{	
				RequestDispatcher rd=request.getRequestDispatcher("addsubject.jsp");
				request.setAttribute("msg","Subject is added successfully..!!");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("addsubject.jsp");
				request.setAttribute("msg","TRY AGAIN..!!");
				rd.forward(request, response);
			}
   		}
   		else
   		{
   			RequestDispatcher rd=request.getRequestDispatcher("addsubject.jsp");
			request.setAttribute("msg","Try another Subject code..!!");
			rd.forward(request, response);
   		}
   		
   		
	}

}
