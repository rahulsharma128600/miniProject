package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.jdbc.DAO;

//import project.jdbc;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signupserv")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String uname=request.getParameter("username");
		String contact=request.getParameter("contact");
		String pswd=request.getParameter("password");
		
		DAO dao = new DAO();
		
		dao.SignUp(name,gender,contact,uname,pswd);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><fieldset><body bgcolor='skyblue'>");
		pw.println("<form  action='signin.html' method='post'>");
		pw.println("<center><h1>--- Successfully Sign-UP ---</h1>");
		
	//	pw.println("<br/><br /><b>Click TO Sigin<input type='submit' value='Signin' /></b>");
		
		pw.println("<br/><br /><b><h2><a href='signin.html'><b>click here to sign-in</b></a></h2></b>");


		pw.println("</form>");
		pw.println("</center></body></fieldset></html>");
		
		pw.close();
		
	}

	 

}
