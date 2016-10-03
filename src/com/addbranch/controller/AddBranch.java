package com.addbranch.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addbranch.dao.AddBranchDao;
import com.addbranch.pojo.AddBranchPojo;

/**
 * Servlet implementation class AddBranch
 */
@WebServlet("/AddBranch")
public class AddBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String branchname=request.getParameter("branchname");
		AddBranchPojo pojo=new AddBranchPojo();
		pojo.setBranchname(branchname);
		
		AddBranchDao dao=new AddBranchDao();
		int branchid1=dao.checkbranch(pojo);
		if(branchid1==0)
		{
			int branchid=dao.addBranch(pojo);
			System.out.println(branchid);
			if(branchid!=0)
			{	
				RequestDispatcher rd=request.getRequestDispatcher("addbranch.jsp");
				request.setAttribute("msg","BRANCH IS ADDED SUCCESSFULLY");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("addbranch.jsp");
				request.setAttribute("msg","TRY AGAIN..!!");
				rd.forward(request, response);
			}
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("addbranch.jsp");
			request.setAttribute("msg","Try another Branch Name");
			rd.forward(request, response);
		}
	}

}
