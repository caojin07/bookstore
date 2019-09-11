package com.util;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

import com.dao.UserMapper;
import com.pojo.User;

public class UserUtil {
	public User getUserByInumber(String inumber) {
		User user = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		user = userMapper.selectByInumber(inumber);
		sqlSession.close();
		return user;
	}
	
	public User getUserById(int id) {
		User user = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		user = userMapper.selectByPrimaryKey(id);
		sqlSession.close();
		return user;
	}
	
	public List<User> getAllUsers() {
		List<User> userlist = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userlist = userMapper.selectAll();
		sqlSession.close();
		return userlist;
	}


	public String Check_login(String password, String md5password) {
		String result = "success";
		String MD5 = AppMD5Util.getMD5(password);
		if (MD5.equals(md5password)) {
			// do nothing
		} else {
			result = "Password incorrect";
		}
		return result;
	}

	public boolean Check_Inumber_allowed(String inumber) {
		boolean flag = true;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.selectByInumber(inumber);
		if (user != null) {
			flag = false;
		}
		sqlSession.close();
		return flag;
	}

	public User Register_User(String inumber, String username, String password, String location, String gender,
			String smallgroup) {
		User user = new User();
		user.setInumber(inumber);
		user.setLocation(location);
		//user.setPassword_mw(password);
		user.setPassword(AppMD5Util.getMD5(password));
		//user.setBirthday(birthday);
		user.setSmallgroup(smallgroup);
		user.setUsername(username);
		user.setGender(gender);

		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		Integer result = userMapper.insert(user);
		if (result != 0) {
			sqlSession.commit();
			user = null;
			user = userMapper.selectByInumber(inumber);
		}
		sqlSession.commit();
		sqlSession.close();
		return user;
	}

	public boolean ChangePasswordById(Integer id, String password) {
		boolean flag = false;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.updatePasswordByPrimaryKey(id, AppMD5Util.getMD5(password));
		sqlSession.commit();
		sqlSession.close();
		return flag;
	}

	public boolean updateUser(User user) {
		boolean flag = false;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer record = userMapper.updateByPrimaryKeySelective(user);
		if (record != null && record == 1) {
			flag = true;
		}
		sqlSession.commit();
		sqlSession.close();
		return flag;
	}
}
