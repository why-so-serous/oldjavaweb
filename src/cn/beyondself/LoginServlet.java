package cn.beyondself;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
                System.out.println(req.getContextPath());

                String user = req.getParameter("user");
                String pass = req.getParameter("pass");	
        	
		String inituser=getServletContext().getInitParameter("username");
         	String initpassword = getServletContext().getInitParameter("password");
                try{
                        System.out.println(new String(user.getBytes("ISO-8859-1"), "UTF-8"));
                }
		catch(Exception e) {
                        System.out.println("encoding error");
                }
                System.out.println(pass);
                System.out.println("test");
                PrintWriter out=resp.getWriter();
               	out.print("user is:"+user+"   "+"password is:"+pass+"   ");
                if(inituser.equals(user)&&initpassword.equals(pass)) {
                                out.print("hello:"+user);
                 }else {
                                out.print("sorry:"+user);
                }
        }

        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
                doPost(req, resp);
        }
	private ServletConfig servletConfig;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = servletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = servletConfig.getServletContext();
		String inituser = servletContext.getInitParameter("user");
		String initpassword = servletContext.getInitParameter("password");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		if(inituser.equals(username) && initpassword.equals(password)) {
			out.print(username + " you have log in nitian.online!");
		}else {
			out.print(username + " login failed!");
		}
	}

}
