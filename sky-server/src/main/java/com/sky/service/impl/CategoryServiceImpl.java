package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-12 11:11
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageResult getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(), categoryPageQueryDTO.getPageSize());
        Page<Category> page = categoryMapper.getAllCategory(categoryPageQueryDTO);
        PageResult pageResult = new PageResult();
        List<Category> categoryList = page.getResult();
        pageResult.setTotal(page.getTotal());
        pageResult.setRecords(categoryList);
        return pageResult;
    }

    /**
     * 根据name、 sort、type、id添加分类
     * @param category
     */
    @Override
    public void addCategory(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(BaseContext.getCurrentId());
        category.setUpdateUser(BaseContext.getCurrentId());
        categoryMapper.addCategory(category);

    }

    @Override
    public List<Category> getCategoryByType(int type) {
        return categoryMapper.getCategoryByType(type);
    }
}


