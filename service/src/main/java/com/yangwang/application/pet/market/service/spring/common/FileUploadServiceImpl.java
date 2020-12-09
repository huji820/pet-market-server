package com.yangwang.application.pet.market.service.spring.common;

import com.yangwang.application.pet.market.common.enums.FileTypeEnum;
import com.yangwang.application.pet.market.common.utils.AliOssObjectUtils;
import com.yangwang.application.pet.market.common.utils.FileUpLoadState;
import com.yangwang.application.pet.market.common.utils.FileUtils;
import com.yangwang.application.pet.market.common.utils.WeChatCheckUtils;
import com.yangwang.application.pet.market.service.facade.common.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LiuXiangLin
 * @version 1.0
 * @className FileUploadServiceImpl
 * @date 2019/10/31 18:25
 **/
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Resource
    AliOssObjectUtils aliOssObjectUtils;

    @Resource
    FileUtils fileUtils;

    @Resource
    WeChatCheckUtils weChatCheckUtils;

    @Override
    public List<FileUpLoadState> uploadFiles(MultipartFile[] multipartFiles) {
        List<FileUpLoadState> result = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {

            // 校验文件类类型
            FileTypeEnum fileTypeEnum = FileTypeEnum.filter(fileUtils.getFileSuffix(multipartFile.getOriginalFilename()));
            if (fileTypeEnum == null) {
                continue;
            }

            //如果是图片需要检测图片是否是敏感图片
            if(fileTypeEnum.getTypeName().equals("图片")){
                //是敏感图片不上传
                if(!weChatCheckUtils.checkImg(multipartFile)){
                    continue;
                }
            }

            // 开始上传文件
            try {
                result.add(aliOssObjectUtils.upLoadImg(multipartFile, fileTypeEnum));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
