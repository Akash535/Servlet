package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		//String e=request.getParameter("uemail");  //null
		
		//String e=request.getParameter("he");		// 1. hidden form field
		
		//String e=request.getParameter("ue");			// 2. Url ReWriting
		
//		Cookie ck[]=request.getCookies();				// 3. Cookie
//		String e=ck[0].getValue();
		
		HttpSession s=request.getSession(false);	// 4. HTTP Session
		String e=(String)s.getAttribute("uemail");
		
		
		out.println("<form align='center'>");
		out.println("<h2>Using HttpSession !!!<h2>");
		out.println("<h4>!!! MY PROFILE !!!<h4>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","akki1312");
			
			PreparedStatement ps=con.prepareStatement("select *from employee where uemail=?");
			ps.setString(1, e);
			ResultSet rs=ps.executeQuery();
			
			out.println("<table  align='center'>");
			if(rs.next()) {
				out.println("<tr><td>Name: </td><td>"+rs.getString("uname")+"</td></tr>");
				out.println("<tr><td>Password: </td><td>"+rs.getString("psw")+"</td></tr>");
				out.println("<tr><td>Address: </td><td>"+rs.getString("address")+"</td></tr>");
				out.println("<tr><td>DOB: </td><td>"+rs.getString("dob")+"</td></tr>");
				out.println("<tr><td>Gender: </td><td>"+rs.getString("gender")+"</td></tr>");
			}
			out.println("</table>");
			out.println("<a href='LogoutServlet'>Logout</a>");
			out.println("</form>");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
