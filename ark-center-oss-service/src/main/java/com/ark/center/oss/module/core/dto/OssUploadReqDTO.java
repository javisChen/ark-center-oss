package com.ark.center.oss.module.core.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
public class OssUploadReqDTO {

    @ApiModelProperty(value = "OSS类型 （MINIO、ALIYUN）", allowableValues = "MINIO,ALIYUN", required = false)
    private String type;
    @ApiModelProperty(value = "bucket（不传就取默认值）", required = false)
    private String bucketName;
    @ApiModelProperty(value = "文件", required = true)
    @NotNull(message = "文件不能为空")
    private MultipartFile file;
}
