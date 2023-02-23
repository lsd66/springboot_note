package com.lsd.springboot_learning.controller;

import com.lsd.springboot_learning.vo.SwaggerReqVO;
import com.lsd.springboot_learning.vo.SwaggerResVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")
@Api(value = "用户接口", tags = {"用户接口"})
public class SwaggerController {
    @ApiOperation("新增用户")
    @PostMapping("save")
    public String save(@RequestBody SwaggerReqVO req) {
        return "success";
    }

    @GetMapping("getById")
    @ApiOperation("根据条件查询用户")
    public SwaggerResVO getById(@RequestBody SwaggerResVO req) {
        return new SwaggerResVO();
    }
}
