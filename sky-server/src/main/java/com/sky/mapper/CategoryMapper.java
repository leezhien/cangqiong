package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-12 11:12
 **/
@Mapper
public interface CategoryMapper {


    Page<Category> getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO) ;

    @Select("select * from category where type = #{type}")
    List<Category> getCategoryByType(int type);
}
