package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-14 10:33
 **/
@Mapper
public interface DishFlavorMapper {


    /**
     * 批量插入口味数据
     * @param flavors
     */

    void insertBatch(@Param("flavors") List<DishFlavor> flavors);


    void deleteByDishId(List<Long> ids);
}
