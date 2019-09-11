package com.servlet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Case;
import org.apache.ibatis.type.IntegerTypeHandler;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.ProgressListener;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.pojo.Book;
import com.pojo.Borrow;
import com.pojo.Subcategory;
import com.pojo.User;
import com.sun.prism.paint.Color;
import com.util.BookUtil;
import com.util.BorrowUtil;
import com.util.UserUtil;
import com.util.ValueUtil;

import javafx.scene.chart.BubbleChart;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/booklist")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookServlet() {
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
		Book book = null;
		HttpSession session = null;
		User user;
		BookUtil bu = null;
		UserUtil uu = null;
		String returnjson = null;
		PrintWriter out = null;
		String category = null;
		String subcategory = null;
		String description = null;
		String bookidstring = null;
		List<Book> bookList = null;
		String pagenumberstring = null;
		Integer pagenumber = null;
		Integer bookid = null;
		Integer totalpages = null;
		String status = null;
		switch (operation) {
		case "edit":
			bookidstring = request.getParameter("id");
			bookid = Integer.parseInt(bookidstring);
			bu = new BookUtil();
			book = bu.GetBookById(bookid);
			request.setAttribute("book", book);
			request.getRequestDispatcher("upload.jsp").forward(request, response);
			break;
		case "upload":
			bookidstring = request.getParameter("id");
			bu = new BookUtil();
			session = request.getSession();
			user = (User) session.getAttribute("me");
			if (bookidstring != null && bookidstring != "") {
				bookid = Integer.parseInt(bookidstring);
				book = bu.GetBookById(bookid);
			} else {
				book = new Book();
				book.setDate(new Date());
				book.setUserid(user.getId());
				book.setStatus("In store");
			}

			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			// 设置系统环境
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(4 * 1024 * 1024);// 设置单个文件大小不能超过4M
			upload.setSizeMax(4 * 1024 * 1024);// 设置总文件上传大小不能超过6M
			// 监听上传进度
			upload.setProgressListener(new ProgressListener() {
				// pBytesRead：当前以读取到的字节数
				// pContentLength：文件的长度
				// pItems:第几项
				public void update(long pBytesRead, long pContentLength, int pItems) {
					System.out.println(
							"Already:" + pBytesRead + " Total:" + pContentLength + "  Current" + pItems + " item");
				}
			});

			// 解析
			try {
				HashMap<String, List<FileItem>> mapitems = (HashMap<String, List<FileItem>>) upload
						.parseParameterMap(request);
				for (Entry<String, List<FileItem>> entry : mapitems.entrySet()) {
					for (FileItem item : entry.getValue()) {
						if (item.isFormField())// 普通字段，表单提交过来的
						{
							String name = item.getFieldName();
							String value = item.getString("UTF-8");
							switch (name) {
							case "category":
								book.setCategory(value);
								break;
							case "name":
								book.setName(value);
								break;
							case "subcategory":
								book.setSubCategory(value);
								break;
							case "description":
								book.setDescription(value);
								break;
							default:
								break;
							}
							System.out.println(name + "==" + value);
						} else {
							// String mimeType = item.getContentType();
							InputStream in = item.getInputStream();
							String fileName = item.getName();
							if (fileName == null || "".equals(fileName.trim())) {
								continue;
							}
							System.out.println(in.available());
							byte[] image = new byte[in.available()];
							in.read(image);
							book.setImage(image);
							in.close();
							item.delete();// 删除临时文件
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (bookidstring != null && bookidstring != "") {
				bu.updateByPrimaryKeyWithBLOBs(book);
			} else {
				bookid = bu.insertBook(book);
			}

			Book newbook = bu.GetBookById(bookid);
			System.out.println(newbook.toString());
			request.setAttribute("mybook", "yes");
			request.getRequestDispatcher("booklist?operation=list&mybook=yes").forward(request, response);
			break;
		case "subcategory":
			category = request.getParameter("category");
			ValueUtil vu = new ValueUtil();
			List<Subcategory> subcategoryList = vu.getSubcategoryByCategory(category);
			JSONArray json = JSONArray.fromObject(subcategoryList);
			returnjson = json.toString();
			out = response.getWriter();
			out.write(returnjson);
			out.close();
			break;
		case "list":
			category = request.getParameter("category");
			if (category == null) {
				category = "all";
			}
			status = request.getParameter("status");
			if (status==null) {
				status = "all";
			}
			String useridstring = request.getParameter("user");
			Integer userid = 0;
			if (useridstring != null && ! useridstring.equals("")) {
				userid = Integer.parseInt(useridstring);
			}
			pagenumberstring = request.getParameter("page");
			if (pagenumberstring != null) {
				pagenumber = Integer.parseInt(pagenumberstring);
			} else {
				pagenumber = 1;
			}
			String mybook = request.getParameter("mybook");
			if (mybook != null && mybook.equals("yes")) {
				session = request.getSession();
				user = (User) session.getAttribute("me");
				bu = new BookUtil();
				bookList = bu.GetBookBypagefilter(pagenumber,category,status,user.getId());
				request.setAttribute("filtercategory", category);
				request.setAttribute("filterstatus", status);
				request.setAttribute("bookList", bookList);
				request.setAttribute("currentpage", pagenumber);
				totalpages = bu.GetTotalPagesfilter(category,status,user.getId());
				request.setAttribute("totalpages", totalpages);
				request.setAttribute("mybook", "yes");
			}else {
				bu = new BookUtil();
				bookList = bu.GetBookBypagefilter(pagenumber,category,status,userid);
				uu = new UserUtil();
				List<User> userlist = uu.getAllUsers();
				request.setAttribute("userlist", userlist);
				request.setAttribute("filtercategory", category);
				request.setAttribute("filterstatus", status);
				request.setAttribute("filteruser", userid);
				request.setAttribute("bookList", bookList);
				request.setAttribute("currentpage", pagenumberstring);
			    totalpages = bu.GetTotalPagesfilter(category,status,userid);
				request.setAttribute("totalpages", totalpages);
			}
			request.getRequestDispatcher("home2.jsp").forward(request, response);
			break;
		case "detail":
			BorrowUtil borrowUtil = new BorrowUtil();
			bookidstring = request.getParameter("id");
			bookid = Integer.parseInt(bookidstring);
			List<Borrow> borrowHistory = borrowUtil.getBorrowHistoryByBook(bookid);
			request.setAttribute("borrowHistory", borrowHistory);
			bu = new BookUtil();
			book = bu.GetBookById(bookid);
			request.setAttribute("book", book);
			request.getRequestDispatcher("book.jsp").forward(request, response);
			break;
		case "image":
			bookidstring = request.getParameter("id");
			if (bookidstring != "") {
				bookid = Integer.parseInt(bookidstring);
			}

			bu = new BookUtil();
			book = bu.GetBookById(bookid);
			byte[] image2 = book.getImage();
			if (image2 != null && image2.length != 0) {
				response.setContentType("image");
				OutputStream aux = response.getOutputStream();
				Integer length = image2.length;
				aux.write(image2, 0, length);
				aux.flush();
				aux.close();
			} else {
				// Read from a file
				response.setContentType("image");
				BufferedImage bi;
				String dir = request.getServletContext().getRealPath("/");
				dir = dir + "img/noimage.png";
				System.out.println(dir);
				File sourceimage = new File(dir);
				bi = ImageIO.read(sourceimage);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bi, "png", baos);
				byte[] bytes = baos.toByteArray();
				OutputStream aux = response.getOutputStream();
				Integer length = bytes.length;
				aux.write(bytes, 0, length);
				aux.flush();
				aux.close();
			}
			break;
		case "delete":
			bookidstring = request.getParameter("id");
			bookid = Integer.parseInt(bookidstring);
			bu = new BookUtil();
			bu.deleteBookById(bookid);
			request.getRequestDispatcher("booklist?operation=list&mybook=yes").forward(request, response);
			break;
		case "right":
			bu = new BookUtil();
			bookList = bu.GetBookByDescending(10);
			JSONArray jsonarray = JSONArray.fromObject(bookList);
			returnjson = jsonarray.toString();
			out = response.getWriter();
			out.write(returnjson);
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
