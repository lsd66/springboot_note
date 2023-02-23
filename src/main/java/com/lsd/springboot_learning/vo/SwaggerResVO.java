package com.lsd.springboot_learning.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("创建Swagger响应结果")
public class SwaggerResVO {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("啥啥")
    private String what;
}
