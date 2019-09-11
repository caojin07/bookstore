package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Case;

import com.pojo.Borrow;
import com.pojo.User;
import com.util.BookUtil;
import com.util.BorrowUtil;

/**
 * Servlet implementation class borrow
 */
@WebServlet("/borrow")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = null;
		User user = null;
		session = request.getSession();
		user = (User) session.getAttribute("me");
		BorrowUtil borrowUtil = new BorrowUtil();
		String borrowidstring = null;
		Integer borrowid;
		PrintWriter out = null;
		Borrow borrow = null;
		String op = request.getParameter("op");
		if (op == null) {
			op = "in";
		}
		BookUtil bUtil = new BookUtil();
		switch (op) {
		case "in":
			List<Borrow> borrowHistory = borrowUtil.getBorrowHistoryByUser(user.getId());
			request.setAttribute("borrowHistory", borrowHistory);
			request.getRequestDispatcher("borrow.jsp").forward(request, response);
			break;
		case "out":
			List<Borrow> borrowoutHistory = borrowUtil.getBorrowoutHistoryByUser(user.getId());
			request.setAttribute("borrowoutHistory", borrowoutHistory);
			request.getRequestDispatcher("borrowout.jsp").forward(request, response);
			break;
		case "confirm":
		case "finish":
		case "reject":
			borrowidstring = request.getParameter("id");
			borrowid = Integer.parseInt(borrowidstring);
			borrowUtil.UpdateStatus(borrowid, op);
			borrow = borrowUtil.getBorrowbyId(borrowid);
			if ("confirm".equals(op)) {
				bUtil.updateStatus(borrow.getBookid(), "Borrow out");
			} else {
				bUtil.updateStatus(borrow.getBookid(), "In store");
			}
			request.getRequestDispatcher("borrow?op=out").forward(request, response);
			break;
		case "comment":
			borrowidstring = request.getParameter("id");
			borrowid = Integer.parseInt(borrowidstring);
			String comment = request.getParameter("comment");
			borrowUtil.UpdateComment(borrowid, comment);
			out = response.getWriter();
			String json = "{\"result\":\"ok\",\"message\":\"save success\"}";
			out.write(json);
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
