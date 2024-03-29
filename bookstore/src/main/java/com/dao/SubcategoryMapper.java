package com.dao;

import java.util.List;

import com.pojo.Category;
import com.pojo.Subcategory;

public interface SubcategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subcategory
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subcategory
     *
     * @mbggenerated
     */
    int insert(Subcategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subcategory
     *
     * @mbggenerated
     */
    int insertSelective(Subcategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subcategory
     *
     * @mbggenerated
     */
    Subcategory selectByPrimaryKey(Integer id);
    
    List<Subcategory> selectByCategory(String category);
    
	List<Subcategory> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subcategory
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Subcategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_subcategory
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Subcategory record);
}