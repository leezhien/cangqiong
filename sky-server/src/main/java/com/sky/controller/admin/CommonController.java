package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.utils.QiniuUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @program: sky-take-out
 * @description:
 * @author: hechunrong
 * @create: 2025-11-13 15:45
 **/
@RestController
@RequestMapping("/admin/common")
@Api("通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private QiniuUtils qiniuUtils;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload( MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String s = UUID.randomUUID() + substring;
        String s1 = qiniuUtils.uploadByBytes(file.getBytes(), s);
        log.info("图片请求地址为{}", s1);
        return Result.success(s1);
    }
}
