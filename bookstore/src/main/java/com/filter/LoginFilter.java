package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
		System.out.println("LoginFilter instaniate");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		// 获得访问界面的url文件地址

		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		if (servletPath.contains(".css") || (!servletPath.contains(".jsp") && servletPath.contains(".js"))
				|| servletPath.contains(".jpg") || servletPath.contains(".png")
				|| servletPath.equals("/register.jsp")
				|| servletPath.equals("/register")) {
			// No need to block
			System.out.println("Before filter");
			// pass the request along the filter chain
			chain.doFilter(request, response);
			System.out.println("After filter");
			return;
		}

		if (servletPath != null && (servletPath.equals("/login") || servletPath.equals("/login.jsp"))) {
			// No need to block
			System.out.println("Before filter");
			// pass the request along the filter chain
			chain.doFilter(request, response);
			System.out.println("After filter");
		} else {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("me");
			if (user == null) {
				RequestDispatcher rd = req.getRequestDispatcher("/login");
				rd.forward(req, res);
			} else {
				System.out.println("Before filter");
				// pass the request along the filter chain
				chain.doFilter(request, response);
				System.out.println("After filter");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
