package com.editprofile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.editprofile.dao.EditProfileDao;
import com.editprofile.pojo.EditProfilePojo;

/**
 * Servlet implementation class ViewProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		int userid = (int)session.getAttribute("userid");
		String firstname = request.getParameter("firstname");   
		String lastname = request.getParameter("lastname");   
	    String email = request.getParameter("email");    
	    String phoneno = request.getParameter("phonenumber");
	    
	   EditProfilePojo pojo =new EditProfilePojo();
	    
	    pojo.setEmail(email);
	    pojo.setFirstname(firstname);
	    pojo.setLastname(lastname);
	    pojo.setPhoneno(phoneno);
	    pojo.setUserid(userid);
	    
	    EditProfileDao dao=new EditProfileDao();
	    try {
			userid=dao.updateManager(pojo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
    	request.setAttribute("msg", "PROFILE EDITED SUCCESSFULLY ");
    	rd.forward(request,response);
	    
	}

}
