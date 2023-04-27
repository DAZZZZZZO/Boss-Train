package com.bosssoft.hr.train.j2se.pojo.entity.file;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @class: OssFileUtils
 * @Description:
 * @Author: Dazo
 * @date: 26/4/2023下午9:46
 */
public class OssFileUtils {
    private static final String endpoint = "your-endpoint";
    private static final String accessKeyId = "your-access-key-id";
    private static final String accessKeySecret = "your-access-key-secret";
    private static final String bucketName = "your-bucket-name";

    public static void upload(File file) {
        /**
         * 创建OSSClient实例
         */
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            /**
             * 获取文件名和文件类型
             */
            String fileName = file.getName();
            String contentType = "application/octet-stream";
            if (fileName.lastIndexOf(".") != -1) {
                contentType = getContentType(fileName.substring(fileName.lastIndexOf(".") + 1));
            }

            /**
             * 设置文件元信息
             */
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(file.length());
            meta.setContentType(contentType);

            /**
             * 上传文件到OSS
             */
            FileInputStream inputStream = new FileInputStream(file);
            ossClient.putObject(bucketName, fileName, inputStream, meta);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
    }

    private static String getContentType(String fileExtension) {
        /**
         * 根据文件扩展名获取文件类型
         */
        switch (fileExtension.toLowerCase()) {
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "png":
                return "image/png";
            case "gif":
                return "image/gif";
            case "pdf":
                return "application/pdf";
            default:
                return "application/octet-stream";
        }
    }
}
