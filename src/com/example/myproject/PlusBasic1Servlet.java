package com.example.myproject;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class PlusBasic1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setContentType("text/html");
		
		resp.getWriter().println("<body>");
		resp.getWriter().println("<form method=\"get\" action=\"http://1-dot-testoauth-1345.appspot.com/validation\">");
		resp.getWriter().println("<h3>");
		resp.getWriter().println("Hello, world.. Basic project. Can you google apis now<br>");
		resp.getWriter().println("Validate using Google Oauth");
/*		resp.getWriter().println("Enter User Name <input type=\"text\" name=\"t1\"> <br>");
		resp.getWriter().println("Enter Password   <input type=\"password\" name=\"t2\"> <br>");
		resp.getWriter().println("<input type=\"submit\" value=\"Please Validate\">");
		resp.getWriter().println("<input type=\"reset\" value=\"Clear Please\">");


		resp.getWriter().println("<a	href=\"https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://1-dot-testoauth-1345.appspot.com&response_type=code&client_id=520681439082-me07kvj4p0ksao7bfqh07j0hef2a1oaa.apps.googleusercontent.com&approval_prompt=force\"");
		resp.getWriter().println("class=\"btn btn-lg btn-social btn-google\"> <i class=\"fa fa-twitter\"></i> Sign in with Abhi's Goooogle Enginee </a>");
*/
	    final GoogleAuthHelper helper = new GoogleAuthHelper();

		ServletRequest session = null;
		
		/*
		 * initial visit to the page
		 */
		resp.getWriter().println("<a href='" + helper.buildLoginUrl() + "'>log in with google</a>");

		//resp.getWriter().println("<a href='http://1-dot-testoauth-1345.appspot.com/validation'>log in with google</a>");
		resp.getWriter().println("</h3>");
		resp.getWriter().println("</body>");
	}
}
