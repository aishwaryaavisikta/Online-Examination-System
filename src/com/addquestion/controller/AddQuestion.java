package com.addquestion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addquestion.dao.AddQuestionDao;
import com.addquestion.pojo.AddQuestionPojo;

/**
 * Servlet implementation class AddQuestion
 */
@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
  		String question=request.getParameter("question");
  		String ans=request.getParameter("ans");
  		String option1=request.getParameter("option1");
  		String option2=request.getParameter("option2");
  		String option3=request.getParameter("option3");
  		String option4=request.getParameter("option4");
  		int subjectid=Integer.parseInt(request.getParameter("subjectid"));
  		String answer=request.getParameter(ans);
  		
  		System.out.println(question);
  		System.out.println(answer);
  		System.out.println(option1);
  		System.out.println(option2);
  		System.out.println(option3);
  		System.out.println(option4);
  		System.out.println(subjectid);
  		
  		AddQuestionPojo pojo=new AddQuestionPojo();
  		pojo.setQuestion(question);
  		pojo.setAnswer(answer);
  		pojo.setOption1(option1);
  		pojo.setOption2(option2);
  		pojo.setOption3(option3);
  		pojo.setOption4(option4);
  		pojo.setSubjectid(subjectid);
  		
  		AddQuestionDao dao=new AddQuestionDao();
  		int questionid=dao.checkquestion(pojo);
  		if(questionid==0)
  		{
  			dao.addquestion(pojo);
  			RequestDispatcher rd=request.getRequestDispatcher("addquestion.jsp?subjectid="+subjectid);
  			request.setAttribute("msg","INSERTION SUCCESSFULL..!!");
  			rd.forward(request, response);
  		}
  		else
  		{
  			RequestDispatcher rd=request.getRequestDispatcher("addquestion.jsp?subjectid="+subjectid);
  			request.setAttribute("msg","INSERTION FAILED..!!");
  			rd.forward(request, response);
  		}
  		
  		
  		
  	}
}