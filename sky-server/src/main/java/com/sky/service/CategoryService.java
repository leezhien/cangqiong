package com.sky.service;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-12 11:10
 **/
public interface CategoryService {
    PageResult getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO);

    List<Category> getCategoryByType(int type);

    void addCategory(Category category);
}
