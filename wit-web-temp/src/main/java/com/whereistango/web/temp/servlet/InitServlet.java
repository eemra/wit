package com.whereistango.web.temp.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whereistango.web.temp.cache.MailCache;

/**
 * Servlet implementation class InitServlet
 * 
 * @author resulav
 */
// @WebServlet(value = "/init", loadOnStartup = 0)
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7329542194624030165L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(
				"\n\t****************************************\n\tInitializing WIT_WEB_TEMP Application...\n\t****************************************");
		MailCache.getInstance().readFromFile();
	}

	@Override
	public void destroy() {
		MailCache.getInstance().writeToFile();
		super.destroy();
		System.out.println(
				"\n\t****************************************\n\tDestroy WIT_WEB_TEMP Application...\n\t****************************************");
	}
}
