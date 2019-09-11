package com.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.*;
import com.pojo.*;

public class ValueUtil {

	public List<Location> getAllLocation() {
		List<Location> LocationList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocationMapper LocationMapper = sqlSession.getMapper(LocationMapper.class);
		LocationList = LocationMapper.selectAllLocation();
		sqlSession.close();
		return LocationList;
	}

	public List<Group> getAllGroup() {
		List<Group> GroupList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroupMapper GroupMapper = sqlSession.getMapper(GroupMapper.class);
		GroupList = GroupMapper.selectAllGroup();
		sqlSession.close();
		return GroupList;
	}
	
	public List<Category> getAllCategory() {
		List<Category> CategoryList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CategoryMapper CategoryMapper = sqlSession.getMapper(CategoryMapper.class);
		CategoryList = CategoryMapper.selectAll();
		sqlSession.close();
		return CategoryList;
	}
	
	public List<Subcategory> getSubcategoryByCategory(String category) {
		List<Subcategory> SubcategoryList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubcategoryMapper SubcategoryMapper = sqlSession.getMapper(SubcategoryMapper.class);
		SubcategoryList = SubcategoryMapper.selectByCategory(category);
		sqlSession.close();
		return SubcategoryList;
	}
	
	public List<Subcategory> getAllSubCategory() {
		List<Subcategory> SubcategoryList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubcategoryMapper SubcategoryMapper = sqlSession.getMapper(SubcategoryMapper.class);
		SubcategoryList = SubcategoryMapper.selectAll();
		sqlSession.close();
		return SubcategoryList;
	}
}
