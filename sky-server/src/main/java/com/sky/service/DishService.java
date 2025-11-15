package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-14 09:59
 **/

public interface DishService {
    void addDish(DishDTO dishDTO);

    PageResult dishPage(DishPageQueryDTO dishPageQueryDTO);

    void deleteDishBatch(List<Long> ids);
}
