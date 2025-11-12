package com.sky.controller.admin;

import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-12 11:05
 **/
@RestController
@Slf4j
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * 分类分页查询
     *
     * @return
     */
    @ApiOperation("分类分页查询")
    @GetMapping("/page")
    public Result<PageResult> getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult result = categoryService.getAllCategory(categoryPageQueryDTO);
        return Result.success(result);
    }

    @ApiOperation("根据类型查询分类")
    @GetMapping("/list")
    public Result<List<Category>> getCategoryByType(int type) {
        List<Category> category = categoryService.getCategoryByType(type);
        return  Result.success(category);
    }

    @ApiOperation("新增分类")
    @PostMapping()
    public Result addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return Result.success();
    }

}
