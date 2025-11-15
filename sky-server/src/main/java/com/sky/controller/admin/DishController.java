package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: sky-take-out
 * @description:菜品管理
 * @author: hechunrong
 * @create: 2025-11-14 09:54
 **/
@RestController
@RequestMapping("/admin/dish")
@Api("菜品相关接口")
@Slf4j
public class DishController {
    @Autowired
    DishService dishService;


    @PostMapping()
    @ApiOperation("添加菜品")
    public Result addDish(@RequestBody DishDTO dishDTO) {
        dishService.addDish(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public  Result<PageResult> dishPage(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = dishService.dishPage(dishPageQueryDTO);
        return Result.success(pageResult);
    }
}
