package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenderSearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String g=request.getParameter("gender");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","akki1312");
			
			PreparedStatement ps=con.prepareStatement("select *from employee where gender=?");
			ps.setString(1, g);
			ResultSet rs=ps.executeQuery();
			out.println("<table>");
			out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Date of Birth</th><th>Designation</th></tr>");
			while(rs.next()) {
				out.println("<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("uname")+"</td><td>"+
			rs.getString("uemail")+"</td><td>"+rs.getString("dob")+"</td><td>"+rs.getString("desig")+"</td>");
			}
			out.println("</table>");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
