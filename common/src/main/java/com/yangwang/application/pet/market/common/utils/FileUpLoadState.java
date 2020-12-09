package com.yangwang.application.pet.market.common.utils;


import com.yangwang.application.pet.market.common.enums.FileTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @ClassName FileUpLoadState
 * @Description 文件上传返回值
 * @Author lsy
 * @Date 2019/10/18
 * @Version 1.0
 **/
@Data
public class FileUpLoadState {

    public static final String SUCCESS = "success";

    @ApiModelProperty("状态")
    String state;

    @ApiModelProperty("新文件名称")
    String newFileName;

    @ApiModelProperty("新文件地址")
    String fileAddress;

    @ApiModelProperty(value = "文件类型")
    FileTypeEnum fileTypeEnum;
}
