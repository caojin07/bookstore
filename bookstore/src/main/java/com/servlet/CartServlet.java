package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pojo.*;
import com.util.BookUtil;
import com.util.BorrowUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Case;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
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
		String operation = request.getParameter("operation");
		String bookidstring;
		HttpSession session;
		Map<String, Book> cartMap = null;
		String returnjason = null;
		Integer userid = null;
		Integer orderid = null;
		PrintWriter out = null;
		Integer booknumber = null;
		User user = null;
		switch (operation) {
		case "remove":
			bookidstring = request.getParameter("id");
			session = request.getSession();
			cartMap = (HashMap<String, Book>) session.getAttribute("cartMap");
			cartMap.remove(bookidstring);
			session.setAttribute("cartMap", cartMap);
			booknumber = cartMap.size();
			returnjason = "{\"message\":\"Success\",\"cartnumber\":\"" + booknumber + "\"}";
			session.setAttribute("booknumber", booknumber);
			out = response.getWriter();
			out.write(returnjason);
			out.close();
			break;
		case "listcart":
			response.sendRedirect("cart.jsp");
			break;
		case "order":
			BorrowUtil bwu = new BorrowUtil();
			session = request.getSession();
			cartMap = (HashMap<String, Book>) session.getAttribute("cartMap");
			user = (User) session.getAttribute("me");
			if (user != null) {
				userid = user.getId();
			}
			if (cartMap != null && cartMap.size() > 0) {
				orderid = bwu.Borrow(userid, cartMap);
				session.setAttribute("cartMap", null);
				request.setAttribute("orderid", orderid);
				request.getRequestDispatcher("borrow").forward(request, response);
			}
			
			break;
		case "add":
			BookUtil bu = new BookUtil();
			bookidstring = request.getParameter("id");
			Integer bookid = Integer.parseInt(bookidstring);
			out = response.getWriter();
			session = request.getSession();
			cartMap = (HashMap<String, Book>) session.getAttribute("cartMap");
			if (cartMap == null) {
				cartMap = new HashMap<String, Book>();
			}
			Book book = bu.GetBookById(bookid);
			if (cartMap.containsKey(bookidstring)) {
				booknumber = cartMap.size();
				returnjason = "{\"message\":\"Already add to cart\",\"cartnumber\":\"" + booknumber + "\"}";
			} else {
				cartMap.put(bookidstring, book);
				booknumber = cartMap.size();
				returnjason = "{\"message\":\"Add to cart successfully\",\"cartnumber\":\"" + booknumber + "\"}";
			}
			session.setAttribute("cartMap", cartMap);
			session.setAttribute("booknumber", booknumber);

			out.write(returnjason);
			out.close();
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
