package com.example.myproject;

import javax.servlet.*;  				
import javax.servlet.http.*;


import com.google.cloud.sql.jdbc.ResultSet;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.example.GooglePojo;
import com.example.GsonUtility;
import com.example.Setup;

import java.io.*; 	
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.example.myproject.DistancePojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Validation extends HttpServlet
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ResultSet rs;

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    try
    {
		res.setContentType("text/html");
	    PrintWriter pw = res.getWriter( );
	    {
	      pw.println("<h3>Thankyou, you are VALID User</h3>");
	      pw.println("<h3>Home Screen </h3>");
	    } 
    

      String code = req.getParameter("code");
      String urlParameters = "code=" + 
        code + 
        "&client_id=" + Setup.CLIENT_ID +
        "&client_secret=" + Setup.CLIENT_SECRET + 
        "&redirect_uri=" + Setup.REDIRECT_URL +
        "&grant_type=authorization_code";
        //+&scope=https://www.googleapis.com/auth/drive";
      URL url = new URL("https://accounts.google.com/o/oauth2/token");
      URLConnection conn = url.openConnection();
      conn.setDoOutput(true);
      
 //     pw.println("<a href='" + urlParameters	+ "'>log in with google</a>");
      
     // pw.println("<h3>Got String 1</h3>");
      OutputStreamWriter writer = new OutputStreamWriter(
        conn.getOutputStream());
     // pw.println("<h3>Got String 2</h3>");
      writer.write(urlParameters);
     // pw.println("<h3>Got String 3</h3>");
      writer.flush();
     // pw.println("<h3>Got String 4</h3>");


      String line1 = "";
      BufferedReader reader = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      String line;
//      pw.println("<h3>Got String 4.1</h3>");
      boolean gs;
      while ((line = reader.readLine()) != null)
      {
  //  	  pw.println("<p>" + line	+ "</p>");
    	  gs = line.contains("access_token");
    	  if (gs == true)
    	  {
    		  break;
    	  }
    	  line1 = line1 + line;
      }
int x=0;
 if(x ==1)
 {
     // String gs = line1;
    //JSONParser parser = new JSONParser();
    //Object obj =  parser.parse(gs);
    //JSONObject jsonObject = (JSONObject) obj; 
 	//String s = "test";//(String) jsonObject.get("access_token");
//     pw.println("<p>" + line	+ "</p>");
     String[] s = line.split(":");
//     pw.println("<p>" + s[1]	+ "</p>");
     String[] gs1 = s[1].split("\"");
     String[] gs2 = gs1[1].split("\"");
//   pw.println("<p>" + gs2[0] 	+ "</p>");
 
 
     //2. Exercise 2: Get the user id details
     url = new URL(
   	        "https://www.googleapis.com/drive/v3/about?fields=user&access_token=" + 
   	        		gs2[0]);
             //"https://www.googleapis.com/auth/youtube?access_token=" +gs2[0]);
   	      pw.println("<p>" + url.toString()	+ "</p>");
   	      conn = url.openConnection();
   	      line1 = "";
   	      reader = new BufferedReader(new InputStreamReader(
   	        conn.getInputStream()));
   	      while ((line = reader.readLine()) != null) {
   	        pw.println("<p>" + line	+ "</p>");
   	        line1 = line1 + line;
   	      }
   	      
   	   
   	   
   	     //2. Exercise 2: Get the user id details
   	     url = new URL(
   	   	        "https://www.googleapis.com/drive/v3/about?fields=user&access_token=" + 
   	   	        		gs2[0]);
   	             //"https://www.googleapis.com/auth/youtube?access_token=" +gs2[0]);
   	   	      pw.println("<p>" + url.toString()	+ "</p>");
   	   	      conn = url.openConnection();
   	   	      line1 = "";
   	   	      reader = new BufferedReader(new InputStreamReader(
   	   	        conn.getInputStream()));
   	   	      while ((line = reader.readLine()) != null) {
   	   	        pw.println("<p>" + line	+ "</p>");
   	   	        line1 = line1 + line;
   	   	      }
 }//if 0
     //1. Exercise 1: Get the user id details
 /*    url = new URL(
        "https://www.googleapis.com/drive/v3/files?corpus=user&access_token=" + 
        		gs2[0]);
      pw.println("<p>" + url.toString()	+ "</p>");
      conn = url.openConnection();
      line1 = "";
      reader = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      while ((line = reader.readLine()) != null) {
        pw.println("<p>" + line	+ "</p>");
        line1 = line1 + line;
      }
      */
 if( x ==1)
 {
      url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=174+Sector+1+HSR+Layout&key="+
      "AIzaSyCRQdCs6V4JEIgUamAg4EkilgH4cWgH6XQ");
      pw.println("<p>" + url.toString()	+ "</p>");
      conn = url.openConnection();
      line1 = "";
      reader = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      while ((line = reader.readLine()) != null) {
        pw.println("<p>" + line	+ "</p>");
        line1 = line1 + line;
      }
      
 //     url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=174+Sector+1+HSR+Layout&key="+
 //     "AIzaSyCRQdCs6V4JEIgUamAg4EkilgH4cWgH6XQ");
      url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC|Seattle&destinations=San+Francisco|Victoria+BC&key=AIzaSyDPATt_y9VsPfeypeOIUU1QIpnGa2lv14M");
      pw.println("<p>" + url.toString()	+ "</p>");
      conn = url.openConnection();
      line1 = "";
      reader = new BufferedReader(new InputStreamReader(
        conn.getInputStream()));
      while ((line = reader.readLine()) != null) {
        pw.println("<p>" + line	+ "</p>");
        line1 = line1 + line;
      }
 }//if x =1
 
 
 /*Testing SQL connection
    */
 int y= 1;
 if(y==1)/*Try out write to google cloud sql*/
 {
	  String url1 = null;
	  try {
			Class.forName("com.mysql.jdbc.GoogleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		url1 = "jdbc:google:mysql://testoauth-1345:us-central1:abhitestoauth3/test?user=abhit&password=abhit";
		
		java.sql.Connection conn1 = null;
		try {
			conn1 = (java.sql.Connection) DriverManager.getConnection(url1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//pw.println( "<a href=\" + err.getMessage( ) + \"</a>");
			pw.println(" <a href=\"./index1.html\">Testing2</a>");
			e.printStackTrace();
			
		}
		
		//pw.println( "<a href=\" + err.getMessage( ) + \"</a>");
		pw.println(" <a href=\"./index1.html\">Testing3</a>");
		java.sql.ResultSet  rs=null;
//		rs= (java.sql.ResultSet ) conn1.createStatement().executeQuery("CREATE TABLE CUSTOMERS;");
//		rs= (java.sql.ResultSet ) conn1.createStatement().executeQuery("USE test;");
		rs= (java.sql.ResultSet ) conn1.createStatement().executeQuery("SELECT * FROM CUSTOMERS;");

		pw.println("<table border='1'>");
		pw.println("<tr>");
		pw.println("<td><b>Nombre</b></td>");
		pw.println("<td><b>Usuario</b></td>");
		pw.println("</tr>");
		
		pw.println("<tr>");
		pw.println("<td><b>Nombre1</b></td>");
		pw.println("<td><b>Usuario1</b></td>");
		pw.println("</tr>");

		while (rs.next()) 
		{
			pw.println("<tr>");
			pw.println("<td>" + rs.getString(1) + "</td>");
			pw.println("<td>" + rs.getString(2) + "</td>");
			pw.println("</tr>");
		}
		
		pw.println("</table>");
		
		conn1.close();

 }
      pw.close( );

      GooglePojo data = (GooglePojo)new Gson().fromJson(line1, GooglePojo.class);
      writer.close();
      reader.close();
      req.setAttribute("auth", data);
      req.getRequestDispatcher("/google.jsp").forward(req, res);
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    catch (ProtocolException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  } 

public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws IOException {
	
	resp.setContentType("text/html");
	
	resp.getWriter().println("<body>");
	resp.getWriter().println("Welcome user, parse userid and display");
	resp.getWriter().println("</body>");
}
}  

/*
https://accounts.google.com/o/oauth2/v2/auth?redirect_uri=https%3A%2F%2Fdevelopers.google.com%2Foauthplayground&prompt=consent&response_type=code&client_id=407408718192.apps.googleusercontent.com&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fplus.login+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fplus.me+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&access_type=offline
*/