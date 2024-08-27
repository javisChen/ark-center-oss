package com.ark.center.foundation.client.file.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FileCommand {

    @ApiModelProperty(value = "文件名称")
    private Long id;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件地址")
    private String uri;

    @ApiModelProperty(value = "文件类型")
    private String mimeType;

    @ApiModelProperty(value = "业务编码")
    private String bizType;

    @ApiModelProperty(value = "文件分组")
    private Long groupId;

}