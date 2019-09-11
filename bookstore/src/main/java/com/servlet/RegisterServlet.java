package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.ibatis.annotations.Case;

import com.pojo.User;
import com.sun.swing.internal.plaf.metal.resources.metal;
import com.util.UserUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("op");
		UserUtil uu = new UserUtil();
		User user = null;
		String returnjson = null;
		PrintWriter out = null;
		String inumber = null;
		String username = null;
		String password = null;
		String location = null;
		String gender = null;
		String smallgroup = null;
		SimpleDateFormat sdf = null;
		String birthdaystring = null;
		HttpSession session = null;
		Date birthday = null;
		if (operation == null) {
			operation = "";
		}
		switch (operation) {
		case "":
		case "register":
			inumber = request.getParameter("inumber");
			username = request.getParameter("username");
			password = request.getParameter("password");
			location = request.getParameter("location");
			gender = request.getParameter("gender");
			smallgroup = request.getParameter("smallgroup");
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			/*birthdaystring = request.getParameter("birthday");
			try {
				birthday = sdf.parse(birthdaystring);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			System.out.println("I Number： " + inumber);
			user = uu.Register_User(inumber, username, password, location, gender, smallgroup);
			if (user != null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
			}
			break;
		case "icheck":
			inumber = request.getParameter("inumber");
			boolean result = uu.Check_Inumber_allowed(inumber);
			String returnjason;
			out = response.getWriter();
			if (result == false) {
				returnjason = "{\"result\":\"error\"}";
				out.write(returnjason);
				out.close();
			} else {
				returnjason = "{\"result\":\"ok\"}";
				out.write(returnjason);
				out.close();
			}
			break;
		case "edit":
			username = request.getParameter("username");
			location = request.getParameter("location");
			gender = request.getParameter("gender");
			smallgroup = request.getParameter("smallgroup");
			/*sdf = new SimpleDateFormat("yyyy-MM-dd");
			birthdaystring = request.getParameter("birthday");
			try {
				birthday = sdf.parse(birthdaystring);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			uu = new UserUtil();
			session = request.getSession();
			user = (User) session.getAttribute("me");
			user.setUsername(username);
			user.setLocation(location);
			user.setGender(gender);
			//user.setBirthday(birthday);
			user.setSmallgroup(smallgroup);
			if (uu.updateUser(user)) {
				session.setAttribute("me", user);
				request.setAttribute("message", "Change success");
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Change failed");
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
			break;
		case "pass":
			String oldpassword = request.getParameter("oldpassword");
			String newpassword = request.getParameter("newpassword");
			session = request.getSession();
			user = (User) session.getAttribute("me");
			System.out.println(oldpassword + newpassword);
			String checkresult = uu.Check_login(oldpassword, user.getPassword());
			if ("success".equals(checkresult)) {
				uu.ChangePasswordById(user.getId(), newpassword);
				user = uu.getUserByInumber(user.getInumber());
				session.setAttribute("me", user);
				out = response.getWriter();
				returnjson = "{\"status\":\"Y\",\"message\":\"success\"}";
				out = response.getWriter();
				out.write(returnjson);
				out.close();
			} else {
				out = response.getWriter();
				returnjson = "{\"status\":\"N\",\"message\":\"" + checkresult + "\"}";
				out = response.getWriter();
				out.write(returnjson);
				out.close();
			}
			break;
		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
