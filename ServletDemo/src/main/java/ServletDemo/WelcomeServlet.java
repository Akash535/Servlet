package ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String e=request.getParameter("uemail");
		out.println("<form align='center'>");
		out.println("<h2 >Welcome : "+e+"</h2>");
		/*---------------------------------------- 1. Hidden form field--------------------------------------------------
		
		 * out.println("<form action='MyProfileServlet' method='get'>");
		 * out.println("<input type='hidden' name='he' value='"+e+"'>");
		 * out.println("<input type='submit' value='MyProfile'><br>"); 
		 * out.println("</form>"); 
		 */
		
		//-------------------------------------------- 2. Url ReWriting----------------------------------------------
		  
		  //out.println("<a href='MyProfileServlet?ue="+e+"'>Myprofile</a>");
		 
		
		//	----------------------------------------------3. Cookie--------------------------------------------
		  
		  //out.println("<a href='MyProfileServlet'>Myprofile</a>");
		  
		  
//			---------------------------------------------- 4. HttpSession --------------------------------------------
		  
		  out.println("<a href='MyProfileServlet'>Myprofile</a>");
		  
		  
		  out.println("<a href='DesigSearch.html'>Designation Search</a>");
		  out.println("<a href='GenderSearch.html'>Gender Search </a>");
		 out.println("</form>");
		
		
	}

}
