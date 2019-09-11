package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Book;
import com.pojo.User;
import com.sun.org.apache.xpath.internal.operations.And;
import com.util.BookUtil;
import com.util.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = null;
		String password = null;
		HttpSession session = null;
		Cookie[] cookies = null;
		String action = request.getParameter("action");
		if (action == null) {
			cookies = request.getCookies();
			for (int i = 0; cookies != null && i < cookies.length; i++) {
				if ("username".equals(cookies[i].getName())) {
					username = cookies[i].getValue();
				}
				if ("password".equals(cookies[i].getName())) {
					password = cookies[i].getValue();
				}
			}
			if (username != null && password != null) {
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.setAttribute("remember", "checked");
			} else {
				request.setAttribute("remember", "unchecked");
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;

		}else if ("logout".equals(action)) {
			session = request.getSession();
			session.invalidate();
		}

		UserUtil uu = new UserUtil();
		username = request.getParameter("username");
		password = request.getParameter("password");
		if (username == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		String remember = request.getParameter("remember");
		User user = uu.getUserByInumber(username);
		String result;
		if (user != null) {
			result = uu.Check_login(password, user.getPassword());
			if ("success".equals(result)) {
				session = request.getSession();
				session.setAttribute("me", user);
				if ("checked".equals(remember)) {
					Cookie usernamecookie = new Cookie("username", username);
					usernamecookie.setMaxAge(24 * 60 * 60);
					Cookie passwordcookie = new Cookie("password", password);
					passwordcookie.setMaxAge(24 * 60 * 60);
					response.addCookie(usernamecookie);
					response.addCookie(passwordcookie);
				} else {
					cookies = request.getCookies();
					for (int i = 0; cookies != null && i < cookies.length; i++) {
						if ("username".equals(cookies[i].getName())) {
							cookies[i].setMaxAge(0);
							response.addCookie(cookies[i]);
						}
						if ("password".equals(cookies[i].getName())) {
							cookies[i].setMaxAge(0);
							response.addCookie(cookies[i]);
						}
					}
				}
				request.getRequestDispatcher("booklist?operation=list&page=1").forward(request, response);

			} else {
				System.out.println("message:" + result);
				request.setAttribute("message", result);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			result = "User not found";
			request.setAttribute("message", result);
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
