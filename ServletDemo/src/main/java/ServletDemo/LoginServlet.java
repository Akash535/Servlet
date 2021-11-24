package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String uemail=request.getParameter("uemail");
		String psw=request.getParameter("psw");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","akki1312");
			
			PreparedStatement ps=con.prepareStatement("select *from employee where uemail=? and psw=?");
			
			ps.setString(1,uemail);
			ps.setString(2, psw);
			
			ResultSet rs=  ps.executeQuery();
			if(rs.next()){
				out.println("Login sucessfully !!!");
				
				
//				Cookie ck=new Cookie("uemail",uemail);
//				response.addCookie(ck);
				
				HttpSession s=request.getSession();
				s.setAttribute("uemail",uemail);
				
				RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
				rd.include(request, response);
				
			}
			else {
				out.println("Try again !!!");
				out.println("please register first !!!");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
