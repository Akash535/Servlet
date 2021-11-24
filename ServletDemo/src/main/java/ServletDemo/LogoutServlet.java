package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
//		  Cookie ck=new Cookie("uemail",null); 
//		  ck.setMaxAge(0); 
//		  response.addCookie(ck);
		 
		
		HttpSession s=request.getSession();
		s.setAttribute("uemail",null);
		s.invalidate();
		out.println("Logout successful !!!");
		RequestDispatcher rd=request.getRequestDispatcher("Login1.html");
		rd.include(request, response);
		
		
	}

}
