package com.exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.AddExamQuestionDao;
import com.exam.pojo.AddExamQuestionPojo;

/**
 * Servlet implementation class AddExamQuestion
 */
@WebServlet("/AddExamQuestion")
public class AddExamQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int branchid=Integer.parseInt(request.getParameter("branchid"));
		int subjectid=Integer.parseInt(request.getParameter("subjectid"));
		int totalmark=Integer.parseInt(request.getParameter("totalmark"));
		int time=Integer.parseInt(request.getParameter("time"));
		int totalquestion=Integer.parseInt(request.getParameter("totalquestion"));
		String date=request.getParameter("date");
		System.out.println(subjectid);
		
		AddExamQuestionPojo pojo=new AddExamQuestionPojo();
		pojo.setBranchid(branchid);
		pojo.setDate(date);
		pojo.setSubjectid(subjectid);
		pojo.setTime(time);
		pojo.setTotalmark(totalmark);
		pojo.setTotalquestion(totalquestion);
		
		AddExamQuestionDao dao=new AddExamQuestionDao();
		int examid=dao.saveExam(pojo);
		System.out.println(examid+"exam");
		if(examid!=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("AddExamQuestion1?subjectid="+subjectid+"&examid="+examid);
			System.out.println(examid+"exam");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Exam");
			rd.forward(request, response);
		}
	}

}
