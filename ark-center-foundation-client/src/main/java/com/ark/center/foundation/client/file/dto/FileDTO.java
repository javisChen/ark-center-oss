package com.ark.center.foundation.client.file.dto;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FileDTO {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "文件名称")
    @NotBlank()
    private String name;

    @ApiModelProperty(value = "文件地址")
    @NotBlank()
    private String uri;

    @ApiModelProperty(value = "文件类型")
    @NotBlank()
    private String mimeType;

    @ApiModelProperty(value = "业务编码")
    @NotBlank()
    private String bizType;

    @ApiModelProperty(value = "文件分组")
    private Long groupId;

}