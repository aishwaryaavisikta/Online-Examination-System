package com.forgetpassword.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forgetpassword.dao.ForgetPasswordDao;
import com.forgetpassword.pojo.ForgetPasswordPojo;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		//String subject=request.getParameter("subject");
		//String msg=request.getParameter("message");
		ForgetPasswordPojo pojo=new ForgetPasswordPojo();
		pojo.setEmail(email);
		
		ForgetPasswordDao dao=new ForgetPasswordDao();
		String password=dao.findPassword(pojo);
		System.out.println(password);
		System.out.println("connected");
		try{
			//properties
			 Properties props = new Properties();  
			  props.put("mail.smtp.host", "smtp.gmail.com");  
			  props.put("mail.smtp.socketFactory.port", "465");  
			  props.put("mail.smtp.socketFactory.class",  
			            "javax.net.ssl.SSLSocketFactory");  
			  props.put("mail.smtp.auth", "true");  
			  props.put("mail.smtp.port", "465");  
			//session
			  Session session=Session.getDefaultInstance(props, 
					  new javax.mail.Authenticator() {  
				   protected PasswordAuthentication getPasswordAuthentication() {  
					   return new PasswordAuthentication("oesmanager0@gmail.com","aishuavy");//change accordingly  
					   }  
					  });

			//compose
			  MimeMessage message = new MimeMessage(session);  
		      message.setFrom(new InternetAddress("oesmanager0@gmail.com"));  
		      message.addRecipient(Message.RecipientType.TO,
		    		  new InternetAddress(email));//"aishwaryaavisikta@gmail.com"
		      message.setSubject("Your password");  
		      message.setText("Check your password and login....!! your password is "+password);  
			//transport
		      Transport.send(message);
		      System.out.println("mail delivered successfully");
		      request.setAttribute("message", "Password is sent..!!");
		      response.sendRedirect("forgetpassword1.jsp");
		      

		}
		catch(Exception e)
		{
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("msg","Try again later..!!");
			rd.forward(request, response);
		}
		
	}
	}

