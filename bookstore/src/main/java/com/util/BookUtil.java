package com.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.dao.BookMapper;
import com.pojo.Book;
import com.pojo.User;

public class BookUtil {
	public List<Book> GetBookByUserpage(Integer userid, Integer pagenumber,String category,String status) {
		List<Book> bookList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		Integer startrecord = (pagenumber - 1) * 8;
		bookList = bookMapper.selectByUserPage(userid, startrecord, 8,category,status);
		sqlSession.close();
		return bookList;
	}

	public List<Book> GetBookBypage(Integer pagenumber) {
		List<Book> bookList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		
		Integer startrecord = (pagenumber - 1) * 8;
		if (startrecord < 0) {
			startrecord = 0;
		}
		bookList = bookMapper.selectByPage(startrecord, 8);
		sqlSession.close();
		return bookList;
	}
	
	public List<Book> GetBookBypagefilter(Integer pagenumber,String category,String status,Integer userid) {
		List<Book> bookList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		
		Integer startrecord = (pagenumber - 1) * 8;
		if (startrecord < 0) {
			startrecord = 0;
		}
		bookList = bookMapper.selectByPageFilter(startrecord, 8,category,status,userid);
		sqlSession.close();
		return bookList;
	}

	public List<Book> GetBookByDescending(Integer record) {
		List<Book> bookList = null;
		SqlSession sqlSession = null;
		UserUtil uu = null;
		User u = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		bookList = bookMapper.selectByDescending(record);
		sqlSession.close();
		uu = new UserUtil();
		for (Book book : bookList) {
			u = uu.getUserById(book.getUserid());
			if (u != null) {
				book.setUser(u);
			}
		}
		
		return bookList;
	}

	public int GetTotalPagesByUser(Integer userid,String category,String status) {
		Integer pages = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		Integer totalrecords = bookMapper.selectCountByUser(userid,category,status);
		pages = (totalrecords + 8 - 1) / 8;
		sqlSession.close();
		return pages;
	}

	public int GetTotalPages() {
		Integer pages = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		Integer totalrecords = bookMapper.selectCount();
		pages = (totalrecords + 8 - 1) / 8;
		sqlSession.close();
		return pages;
	}

	public int GetTotalPagesfilter(String category,String status,Integer userid) {
		Integer pages = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		Integer totalrecords = bookMapper.selectCountFilter(category,status,userid);
		pages = (totalrecords + 8 - 1) / 8;
		sqlSession.close();
		return pages;
	}
	public Book GetBookById(Integer id) {
		SqlSession sqlSession = null;
		UserUtil uu = null;
		User u = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		Book book = bookMapper.selectByPrimaryKey(id);
		sqlSession.close();
		if (book != null) {
			uu = new UserUtil();
			u = uu.getUserById(book.getUserid());
			if (u != null) {
				book.setUser(u);
			}
		}

		return book;
	}

	public int insertBook(Book book) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		System.out.println(book.getDescription());
		System.out.println(book.getDescription().length());
		bookMapper.insertSelective(book);
		sqlSession.commit();
		sqlSession.close();
		return book.getId();
	}

	public int deleteBookById(Integer id) {
		Integer result = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		result = bookMapper.deleteByPrimaryKey(id);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int updateByPrimaryKeyWithBLOBs(Book book) {
		Integer result = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		result = bookMapper.updateByPrimaryKeyWithBLOBs(book);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public boolean updateStatus(Integer id, String status) {
		boolean flag = false;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
		Book book = bookMapper.selectByPrimaryKey(id);
		book.setStatus(status);
		Integer result = bookMapper.updateByPrimaryKey(book);
		sqlSession.commit();
		sqlSession.close();
		if (result == 1) {
			flag = true;
		}
		return flag;
	}
}
