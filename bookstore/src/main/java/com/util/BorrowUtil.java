package com.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dao.BorrowMapper;
import com.dao.BookMapper;
import com.pojo.Book;
import com.pojo.Borrow;
import com.pojo.User;

import javafx.scene.chart.BubbleChart;

public class BorrowUtil {
	public int getNextOrderId() {
		Integer result = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		result = borrowMapper.selectMaxOrder();
		sqlSession.close();
		return result + 1;
	}

	public Borrow getBorrowbyId(Integer id) {
		Borrow borrow = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		borrow = borrowMapper.selectByPrimaryKey(id);
		sqlSession.close();
		return borrow;
	}

	public int Borrow(Integer userid, Map<String, Book> cartMap) {
		List borrowList = new ArrayList<Borrow>();
		Borrow borrow;
		Integer orderid = null;
		orderid = getNextOrderId();
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

		Book book;
		if (cartMap.size() == 0) {
			return 0;
		}
		Iterator iter = cartMap.entrySet().iterator();
		while (iter.hasNext()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) iter.next();
			book = (Book) entry.getValue();
			borrow = new Borrow();
			borrow.setBookid(book.getId());
			borrow.setStatus("order");
			borrow.setBookid(book.getId());
			borrow.setOrderid(orderid);
			borrow.setUserid(userid);
			borrow.setStartdate(new Date());
			borrowMapper.insertSelective(borrow);
			borrowList.add(borrow);

			book.setStatus("order");
			bookMapper.updateByPrimaryKeySelective(book);
		}
		sqlSession.commit();
		sqlSession.close();
		return orderid;
	}

	public List<Borrow> getBorrowHistoryByBook(Integer bookid) {
		List<Borrow> borrowList = null;
		UserUtil uu = null;
		User u = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		borrowList = borrowMapper.selectByBook(bookid);
		sqlSession.close();
		uu = new UserUtil();
		for (Borrow borrow : borrowList) {
			u = uu.getUserById(borrow.getUserid());
			borrow.setUser(u);
		}
		
		return borrowList;
	}

	public List<Borrow> getBorrowHistoryByUser(Integer userid) {
		List<Borrow> borrowList = null;
		SqlSession sqlSession = null;
		Book b = null;
		BookUtil bu = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		borrowList = borrowMapper.selectByUser(userid);
		sqlSession.close();
		bu = new BookUtil();
		for (Borrow borrow : borrowList) {
			b = bu.GetBookById(borrow.getBookid());
			borrow.setBook(b);
		}
		
		return borrowList;
	}

	public void UpdateStatus(Integer borrowid, String status) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		Borrow borrow = borrowMapper.selectByPrimaryKey(borrowid);
		borrow.setStatus(status);
		if ("finish".equals(status)) {
			borrow.setEnddate(new Date());
		}
		borrowMapper.updateByPrimaryKey(borrow);
		sqlSession.commit();
		sqlSession.close();
	}

	public void UpdateComment(Integer borrowid, String comment) {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		Borrow borrow = borrowMapper.selectByPrimaryKey(borrowid);
		borrow.setComment(comment);
		borrowMapper.updateByPrimaryKey(borrow);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<Borrow> getBorrowoutHistoryByUser(Integer userid) {
		List<Borrow> borrowoutList = null;
		SqlSession sqlSession = null;
		UserUtil uu = null;
		BookUtil bu = null;
		User u = null;
		Book b = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
		borrowoutList = borrowMapper.selectOutByUser(userid);
		uu = new UserUtil();
		bu = new BookUtil();
		
		sqlSession.close();
		for (Borrow borrow : borrowoutList) {
			u = uu.getUserById(borrow.getUserid());
			borrow.setUser(u);

			b = bu.GetBookById(borrow.getBookid());
			borrow.setBook(b);
		}

		return borrowoutList;
	}
}
