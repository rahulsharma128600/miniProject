package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.jdbc.DAO;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/signinserv")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("username");
		String pswd=request.getParameter("password");
		
		DAO dao =new DAO();
		
	
		
		
		response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
		
		
		if(dao.SignIn(uname, pswd))
		{
			pw.println("<html><fieldset></center><body bgcolor='green'>");

				pw.println("</br></br><h1><center><i>----------- Welcome ------------------</i></center></h1></br></br>");
				pw.println("</br><h2><center>--------- LOGIN SUCCESS  --------</center></h2></br>");				
				pw.println("<form  action='home.html' method='post'>");
				pw.println("<br/><br /><b>&emsp;<input type='submit'  value='Back TO HOME' /></b>");
				pw.println("</form >");

		
		} else
		{
			pw.println("<html><fieldset></center><body bgcolor='red'>");

			pw.println("</br><h1><center>--------- INVALID CREDENTIALS  --------</center></h1></br>");
			pw.println("<form  action='signin.html' method='post'>");
			pw.println("<br/><br /><b>&emsp;<input type='submit'  value='Back TO Signin' /></b>");
			pw.println("</form >");
		}
		

		pw.println("</body></fieldset></html></center>");

		pw.close();
		
		
	}

}
