package com.ark.center.foundation.client.file.command;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文件分组表
 * </p>
 *
 * @author
 * @since 2024-08-27
 */
@Data
public class FileGroupCommand {

    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "父级路由id")
    private Long pid;

    @ApiModelProperty(value = "层级路径")
    private String path;

    @ApiModelProperty(value = "层级")
    private Integer level;

}