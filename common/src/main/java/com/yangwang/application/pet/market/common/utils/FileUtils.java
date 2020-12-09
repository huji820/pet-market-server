package com.yangwang.application.pet.market.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @ClassName FileUtils
 * @Description 文件工具类
 * @Author LSY
 * @Date 2019/10/18
 * @Version 1.0
 **/

@Component
public class FileUtils {
    @Value("${file.upload-Path}")
    String baseFilePath;

    /**
     * 获取新文件名称
     */
    String getNewFileName(String oldFileName) {
        return System.currentTimeMillis() + "-" + StringUtils.getUuid() + "." + getFileSuffix(oldFileName);
    }

    /**
     * 删除文件
     * @param imgUrl
     */
    public void deleteImgPath(String imgUrl) {
        File fileDir = new File(baseFilePath + imgUrl);

        fileDir.delete();
    }

    /**
     * <p>
     * 获取文件后缀名
     * </p>
     *
     * @param fileName 文件名称
     * @return java.lang.String
     * @author LiuXiangLin
     * @date 14:22 2020/3/22
     **/
    public String getFileSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
