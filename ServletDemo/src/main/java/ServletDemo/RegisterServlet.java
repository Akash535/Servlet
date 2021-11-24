package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
//		out.println("<h3>Hello</h3>");
//		out.println("<h1>Akash Shingade</h1>");
		
		
		String uname=request.getParameter("uname");
		String psw=request.getParameter("psw");
		String uemail=request.getParameter("uemail");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String desig=request.getParameter("desig");
		String dob=request.getParameter("dob");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","akki1312");
			
			PreparedStatement ps=con.prepareStatement("insert into employee (uname,uemail,psw,gender,address,desig,dob)"
					+ " values(?,?,?,?,?,?,?)");
			
			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setString(3, psw);
			ps.setString(4, gender);
			ps.setString(5, address);
			ps.setString(6, desig);
			ps.setString(7,dob);
			
			int i=ps.executeUpdate();
			if(i==1) {
				//New User Here !!!
				out.println(" Registration Successfully  !!!");
				out.println("Go to <a href='Login1.html'>Login</a> page !!!");
			}else
				out.println("try again !!!");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
