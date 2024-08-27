package com.ark.center.foundation.client.file.query;

import com.ark.component.dto.PagingQuery;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileQuery extends PagingQuery {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "业务编码")
    @NotBlank()
    private String bizType;

    @ApiModelProperty(value = "文件分组")
    private Long groupId;

}