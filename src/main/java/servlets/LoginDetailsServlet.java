package servlets;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.User;
import helper.FactoryProvider;


public class LoginDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		
		try
		{
			String email = request.getParameter("email");
			
			String pwd = request.getParameter("pwd");
			
			PrintWriter out = response.getWriter();
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
		
			Query q = s.createQuery("from User");
			List<User> list = q.list();
			User current_user = new User();
			
			for(User user:list)
			{
				if(user.getEmail().equals(email) && user.getPassword().equals(pwd))
				{
					i =  1;
					current_user = user;
					break;
				}
				
			}
			
			if(i == 1)
			{
				if(current_user.getRole().equals("content-author"))
				{
				ServletContext servletcontext = getServletContext();
				servletcontext.setAttribute("current_user_id", current_user.getUser_id());
				//out.println("<h1 style='text-align:center;'>Welcome !!</h1>");
				//out.println("<h1 style='text-align:center;'><a href='View.jsp'>Continue</a></h1>");
				response.sendRedirect("contentauthor.jsp?id="+Integer.toString(current_user.getUser_id()));
			
				}
				else if(current_user.getRole().equals("content-admin"))
				{
				ServletContext servletcontext = getServletContext();
				servletcontext.setAttribute("current_user_id", current_user.getUser_id());
				//out.println("<h1 style='text-align:center;'>Welcome !!</h1>");
				//out.println("<h1 style='text-align:center;'><a href='View.jsp'>Continue</a></h1>");
				response.sendRedirect("ContentAdmin.jsp?id="+Integer.toString(current_user.getUser_id()));
				}
				else if(current_user.getRole().equals("template-author"))
				{
				ServletContext servletcontext = getServletContext();
				servletcontext.setAttribute("current_user_id", current_user.getUser_id());
				//out.println("<h1 style='text-align:center;'>Welcome !!</h1>");
				//out.println("<h1 style='text-align:center;'><a href='View.jsp'>Continue</a></h1>");
				response.sendRedirect("createXML.html?id="+Integer.toString(current_user.getUser_id()));
				}
					
			}
			else
			{
				out.println("<div class='text-center'><h1 style='text-align:center;'>Invalid Email Address or Password !!<br><a  href='Login.jsp'>Back</a></h1></div><br>");
			}
			
			tx.commit();
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
