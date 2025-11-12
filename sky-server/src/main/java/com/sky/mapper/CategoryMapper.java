package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.*;

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

    @Insert("INSERT INTO category (name, sort, type, create_time, update_time, create_user, update_user,status) VALUES (#{name}, #{sort}, #{type}, " +
            "#{createTime}, #{updateTime},  #{createUser}, #{updateUser}, #{status} )")
    void addCategory(Category category);

    @Delete("delete from category where id = #{id}")
    void deleteCategoryById(int id);



    @Update("update category set status = #{status} where id = #{id}")
    void updateCategoryStatus(@Param("status") int status, @Param("id") int id);

    @Update("update category set name = #{name}, sort= #{sort}, update_time = #{updateTime}, update_user = #{updateUser} where id = #{id}")
    void updateCategoryById(Category category);
}
