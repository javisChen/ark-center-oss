package com.kt.cloud.oss.module.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class OssUploadRespDTO {

    @ApiModelProperty(value = "oss地址", required = true)
    private String url;
}
