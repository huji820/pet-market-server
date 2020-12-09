package com.yangwang.application.pet.market.common.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.yangwang.application.pet.market.common.enums.FileTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * <p>
 * 阿里文件上传类
 * </p>
 *
 * @author LiuXiangLin
 * @date 14:16 2020/3/17
 **/
@Component
public class AliOssObjectUtils {
    /**
     * 连接使用KEY
     */
    private String accessKeyId;

    /**
     * 连接使用的秘钥
     */
    private String accessKeySecret;

    /**
     * 容器名称
     */
    private String bucketName;

    /**
     * 域名地址
     */
    private String endpoint;

    /**
     * 工具类
     */
    private FileUtils fileUtils;

    /**
     * 连接客户端
     */
    private OSS ossClient;

    @Autowired
    public AliOssObjectUtils(@Value("${aliyun.oss.accessKeyId}") String accessKeyId,
                             @Value("${aliyun.oss.accessKeySecret}") String accessKeySecret,
                             @Value("${aliyun.oss.bucketName}") String bucketName,
                             @Value("${aliyun.oss.endpoint}") String endpoint,
                             FileUtils fileUtils) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
        this.endpoint = endpoint;
        this.fileUtils = fileUtils;
        initOssClient();
    }

    /**
     * 初始化连接客户端
     *
     * @author lsy
     * @date 9:00 2019/12/24
     **/
    private void initOssClient() {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    public FileUpLoadState upLoadImg(MultipartFile multipartFile, FileTypeEnum fileTypeEnum) throws IOException {
        FileUpLoadState result;

        // 新文件名
        String newFileName = fileUtils.getNewFileName(multipartFile.getOriginalFilename());

        // 上传文件
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, newFileName, multipartFile.getInputStream());

        // 上传文件判断状态
        if (putObjectResult == null) {
            return null;
        }

        // 生成签名链接
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, newFileName);
        // 设置超时时间
        generatePresignedUrlRequest.setExpiration(new Date(System.currentTimeMillis() + 3600L * 1000L * 24L * 365L * 100));
        // 获取URL对象
        URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);

        // 设置返回值对象
        result = new FileUpLoadState();
        result.setFileAddress(url.toString());
        result.setNewFileName(newFileName);
        result.setState(FileUpLoadState.SUCCESS);
        result.setFileTypeEnum(fileTypeEnum);

        return result;
    }
}
