package com.whereistango.web.temp.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class InitServlet
 * 
 * @author resulav
 */
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7329542194624030165L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("****************************************");
		System.out.println("Initializing WIT_WEB_TEMP Application...");
		System.out.println("****************************************");

		System.out.println("Initialized WIT_WEB Application.!");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destroy WIT_WEB_TEMP Application...");
	}

}
