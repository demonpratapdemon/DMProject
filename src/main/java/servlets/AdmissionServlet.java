package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Transform.Transform;

/**
 * Servlet implementation class AdmissionServlet
 */
public class AdmissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdmissionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String template = request.getParameter("template");
			System.out.println(template);
			String path = Transform.transform("xml/AdmissionTemplate1.xml", "xslt/sample.xsl", "Admissions.html");
			String path1 = Transform.transform("xml/static.xml", "xslt/ContentAdmin.xsl", "ContentAdmissions.html");
			System.out.println(path);
			System.out.println(path1);
			response.sendRedirect("Admissions.html");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
