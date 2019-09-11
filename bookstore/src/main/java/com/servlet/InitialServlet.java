package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Category;
import com.pojo.Group;
import com.pojo.Location;
import com.pojo.Subcategory;
import com.util.ValueUtil;

/**
 * Servlet implementation class InitialServlet
 */
@WebServlet(urlPatterns = "/Initial",loadOnStartup=1 )
public class InitialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("Initial servlet init called");
		ValueUtil vu = new ValueUtil();
		ServletContext app = this.getServletContext();
		List<Group> groupList = vu.getAllGroup();
		app.setAttribute("grouplist", groupList);
		List<Location> locationList = vu.getAllLocation();
		app.setAttribute("locationlist", locationList);
		List<Category> categoryList = vu.getAllCategory();
		app.setAttribute("categorylist", categoryList);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Initial servlet destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
