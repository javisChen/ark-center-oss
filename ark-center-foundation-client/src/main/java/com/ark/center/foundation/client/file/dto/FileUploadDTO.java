package com.ark.center.foundation.client.file.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileUploadDTO {

    @ApiModelProperty(value = "oss地址", required = true)
    private String url;

}
