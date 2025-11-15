package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-15 14:55
 **/
@Mapper
public interface SetmealDishMapper {

    //@Select("select setmeal_id from sky_take_out.setmeal_dish where dish_id = #{id}")
    List<Long> geSetmealIdByDishd(List<Long> ids);
}
